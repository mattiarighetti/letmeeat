package com.nexi.letmeeat.services;

import com.nexi.letmeeat.db.OrderRepository;
import com.nexi.letmeeat.db.PaymentRepository;
import com.nexi.letmeeat.db.SeatRepository;
import com.nexi.letmeeat.db.UserRepository;
import com.nexi.letmeeat.model.Payment;
import com.nexi.letmeeat.resoruces.CreateOrderResponse;
import com.nexi.letmeeat.resoruces.PaymentRedirectResponse;
import com.nexi.letmeeat.utils.EmailService;
import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;
import com.paypal.http.HttpResponse;
import com.paypal.orders.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.NoSuchElementException;

@Service
public class PayPalService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private EmailService emailService;

    private PayPalHttpClient client;

    public PayPalService(@Value("${paypal.client.id}") String clientId,
                                @Value("${paypal.client.secret}") String clientSecret) {
        client = new PayPalHttpClient(new PayPalEnvironment.Sandbox(clientId, clientSecret));
    }

    public PaymentRedirectResponse createOrder(Double amount, Long userId, Long seatId, Long orderId, HttpServletRequest request) throws IOException {

        URI returnUrl = buildReturnUrl(request, orderId);

        final OrderRequest orderRequest = createOrderRequest(amount, returnUrl);
        final OrdersCreateRequest ordersCreateRequest = new OrdersCreateRequest().requestBody(orderRequest);
        final HttpResponse<Order> orderHttpResponse = client.execute(ordersCreateRequest);
        final Order order = orderHttpResponse.result();
        LinkDescription approveUri = extractApprovalLink(order);

        paymentRepository.save(Payment.builder()
                .seat(seatRepository.findById(seatId).orElse(null))
                .user(userRepository.findById(userId).orElse(null))
                .status("CREATED")
                .total_amount(amount)
                .build());

        return new PaymentRedirectResponse(URI.create(approveUri.href()).toString());
    }

    private OrderRequest createOrderRequest(Double totalAmount, URI returnUrl) {
        final OrderRequest orderRequest = new OrderRequest();
        setCheckoutIntent(orderRequest);
        setPurchaseUnits(totalAmount, orderRequest);
        setApplicationContext(returnUrl, orderRequest);
        return orderRequest;
    }

    private OrderRequest setApplicationContext(URI returnUrl, OrderRequest orderRequest) {
        return orderRequest.applicationContext(new ApplicationContext().returnUrl(returnUrl.toString()));
    }

    private void setPurchaseUnits(Double totalAmount, OrderRequest orderRequest) {
        final PurchaseUnitRequest purchaseUnitRequest = new PurchaseUnitRequest()
                .amountWithBreakdown(new AmountWithBreakdown().currencyCode("EUR").value(totalAmount.toString()));
        orderRequest.purchaseUnits(Arrays.asList(purchaseUnitRequest));
    }

    private void setCheckoutIntent(OrderRequest orderRequest) {
        orderRequest.checkoutPaymentIntent("CAPTURE");
    }

    private LinkDescription extractApprovalLink(Order order) {
        order.links().forEach(link -> System.out.println(link.href()));
        return order.links().stream()
                .filter(linkDescription -> linkDescription.href().contains("token"))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    private URI buildReturnUrl(HttpServletRequest request, Long orderId) {
        try {
            URI requestUri = URI.create(request.getRequestURL().toString());
            return new URI(requestUri.getScheme(),
                    requestUri.getUserInfo(),
                    requestUri.getHost(),
                    requestUri.getPort(),
                    "/payment/success",
                    "orderId=" + orderId, null);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
