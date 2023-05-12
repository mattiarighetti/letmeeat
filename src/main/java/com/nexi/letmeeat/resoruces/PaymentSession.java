package com.nexi.letmeeat.resoruces;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentSession {
    @JsonProperty
    public String actionType;
    @JsonProperty
    public Long amount;
    @JsonProperty
    public Recurrence recurrence;
    @JsonProperty
    public String captureType;
    @JsonProperty
    public String exemptions;
    @JsonProperty
    public String language;
    @JsonProperty
    public String notificationUrl;
    @JsonProperty
    public String paymentService;
}
