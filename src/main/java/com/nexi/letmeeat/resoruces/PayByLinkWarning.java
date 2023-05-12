package com.nexi.letmeeat.resoruces;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PayByLinkWarning {
    @JsonProperty
    public String code;
    @JsonProperty
    public String description;
}
