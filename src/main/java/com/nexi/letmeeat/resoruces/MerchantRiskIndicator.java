package com.nexi.letmeeat.resoruces;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MerchantRiskIndicator {
    @JsonProperty
    public String deliveryEmail;
    @JsonProperty
    public String deliveryTimeframe;
    @JsonProperty
    public Object giftCardAmount;
    @JsonProperty
    public int giftCardCount;
    @JsonProperty
    public String preOrderDate;
    @JsonProperty
    public String preOrderPurchaseIndicator;
    @JsonProperty
    public String reorderItemsIndicator;
    @JsonProperty
    public String shipIndicator;
}
