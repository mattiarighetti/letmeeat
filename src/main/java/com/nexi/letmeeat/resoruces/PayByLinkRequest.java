package com.nexi.letmeeat.resoruces;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PayByLinkRequest {
    @JsonProperty
    public XPayOrder order;
    @JsonProperty
    public PaymentSession paymentSession;
    @JsonProperty
    public String expirationDate;
}
