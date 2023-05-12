package com.nexi.letmeeat.resoruces;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentLink {
    @JsonProperty
    public String linkId;
    @JsonProperty
    public String amount;
    @JsonProperty
    public String expirationDate;
    @JsonProperty
    public String link;
    @JsonProperty
    public String paidByOperationId;
    @JsonProperty
    public String status;
}
