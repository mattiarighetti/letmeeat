package com.nexi.letmeeat.resoruces;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderModel {

    @JsonProperty
    private Long dishId;

    @JsonProperty
    private Long seatId;
}
