package com.nexi.letmeeat.resoruces;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class OrderModel {

    @JsonProperty
    private List<Long> dishIds;

    @JsonProperty
    private Long seatId;
}
