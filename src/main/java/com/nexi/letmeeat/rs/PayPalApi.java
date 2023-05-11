package com.nexi.letmeeat.rs;

import com.nexi.letmeeat.resoruces.CreateOrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface PayPalApi {

    @GetMapping("/order/success")
    public ResponseEntity<String> orderSuccess() throws IOException;

    @PostMapping("/order/create")
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestParam Double totalAmount,
                                                          @RequestParam Long userId,
                                                          @RequestParam Long seatId,
                                                          HttpServletRequest request)
            throws IOException;

    @PostMapping("/email/receipt")
    public ResponseEntity<String> sendReceipt(@RequestParam Long paymentId,
                                              @RequestParam Long orderId)
            throws IOException;

}
