package com.nexi.letmeeat.resoruces;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class PayByLinkResponse {
    @JsonProperty
    public PaymentLink paymentLink;
    @JsonProperty
    public String securityToken;
    @JsonProperty
    public ArrayList<PayByLinkWarning> warnings;
}
