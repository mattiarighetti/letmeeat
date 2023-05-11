package com.nexi.letmeeat.rs;

import com.nexi.letmeeat.resoruces.CreateOrderResponse;
import com.nexi.letmeeat.services.PayPalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class PayPalController implements PayPalApi{

    @Autowired
    private PayPalService payPalService;

    @Override
    public ResponseEntity<String> orderSuccess() throws IOException {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestParam Double totalAmount,
                                                          @RequestParam Long userId,
                                                          @RequestParam Long seatId,
                                                          HttpServletRequest request) throws IOException {
        final URI returnUrl = buildReturnUrl(request);
        CreateOrderResponse createOrderResponse = payPalService.createOrder(totalAmount, userId, seatId, returnUrl);
        return new ResponseEntity<>(createOrderResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> sendReceipt(@RequestParam Long paymentId,
                                              @RequestParam Long orderId) {
        payPalService.successOrder(paymentId, orderId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private URI buildReturnUrl(HttpServletRequest request) {
        try {
            URI requestUri = URI.create(request.getRequestURL().toString());
            return new URI(requestUri.getScheme(),
                    requestUri.getUserInfo(),
                    requestUri.getHost(),
                    requestUri.getPort(),
                    "/email/success",
                    null, null);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}
