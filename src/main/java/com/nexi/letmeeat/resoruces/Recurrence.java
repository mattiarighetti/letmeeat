package com.nexi.letmeeat.resoruces;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Recurrence {
    @JsonProperty
    public String action;
    @JsonProperty
    public String contractId;
    @JsonProperty
    public String contractType;
}
