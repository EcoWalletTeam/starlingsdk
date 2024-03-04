package com.ecowallet.starlingsdk.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StarlingAmount {
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("minorUnits")
    private Integer minorUnits;
}
