package com.nexi.letmeeat.resoruces;

import lombok.Data;

import java.net.URI;

@Data
public class CreateOrderResponse {
    private final String orderId;
    private final URI approvalLink;
    private final Long paymentId;
}
