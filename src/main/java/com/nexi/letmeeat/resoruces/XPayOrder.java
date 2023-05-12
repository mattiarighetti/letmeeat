package com.nexi.letmeeat.resoruces;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class XPayOrder {
    @JsonProperty
    public String orderId;
    @JsonProperty
    public Long amount;
    @JsonProperty
    public String currency;
    @JsonProperty
    public String customerId;
    @JsonProperty
    public String description;
    @JsonProperty
    public String customField;
    @JsonProperty
    public CustomerInfo customerInfo;
    @JsonProperty
    public ArrayList<String> termsAndConditionsIds;
}
