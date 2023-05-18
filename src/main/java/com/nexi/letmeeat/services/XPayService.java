package com.nexi.letmeeat.services;

import com.nexi.letmeeat.db.OrderRepository;
import com.nexi.letmeeat.db.PaymentRepository;
import com.nexi.letmeeat.db.UserRepository;
import com.nexi.letmeeat.model.Order;
import com.nexi.letmeeat.model.Payment;
import com.nexi.letmeeat.resoruces.PayByLinkRequest;
import com.nexi.letmeeat.resoruces.PayByLinkResponse;
import com.nexi.letmeeat.resoruces.PaymentRedirectResponse;
import com.nexi.letmeeat.utils.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Date;
import java.util.UUID;

@Service
public class XPayService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private OrderRepository orderRepository;

    public PaymentRedirectResponse payByLink(PayByLinkRequest payByLinkRequest, Long userId, Long orderId, String restaurantName, Double amount) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Api-Key", "06aa13b7-bdeb-4c7a-b4ef-4e8050f6ae7c");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Correlation-Id", UUID.randomUUID().toString());

        HttpEntity<PayByLinkRequest> entity = new HttpEntity<>(payByLinkRequest, headers);

        ResponseEntity<PayByLinkResponse> response = restTemplate.exchange(
                "https://xpaysandbox.nexigroup.com/api/phoenix-0.0/psp/api/v1/orders/paybylink",
                HttpMethod.POST,
                entity,
                PayByLinkResponse.class);

        paymentRepository.save(Payment.builder()
                .user(userRepository.findById(userId).orElse(null))
                .status("CREATED")
                .restaurantName(restaurantName)
                .total_amount(amount)
                .orderId(orderId)
                .timestamp(new Date())
                .build());
        Order order = orderRepository.findById(orderId).orElse(null);
        emailService.sendEmail(order);

        return new PaymentRedirectResponse(response.getBody().getPaymentLink().getLink());
    }

}
