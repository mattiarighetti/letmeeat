package com.nexi.letmeeat.resoruces;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerInfo {
    @JsonProperty
    public String cardHolderName;
    @JsonProperty
    public String cardHolderEmail;
    @JsonProperty
    public BillingAddress billingAddress;
    @JsonProperty
    public ShippingAddress shippingAddress;
    @JsonProperty
    public String mobilePhone;
    @JsonProperty
    public CardHolderAcctInfo cardHolderAcctInfo;
}
