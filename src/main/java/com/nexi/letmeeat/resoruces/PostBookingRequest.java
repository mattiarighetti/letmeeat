package com.nexi.letmeeat.resoruces;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Data
public class PostBookingRequest {

    @JsonProperty
    private Long tableId;
    @JsonProperty
    private Long userId;
    @JsonProperty
    private Long restaurantId;

}
