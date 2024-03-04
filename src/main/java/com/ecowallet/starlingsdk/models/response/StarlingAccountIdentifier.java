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
public class StarlingAccountIdentifier {
    @JsonProperty("accountIdentifier")
    private String accountIdentifier;
    @JsonProperty("bankIdentifier")
    private String bankIdentifier;
    @JsonProperty("iban")
    private String iban;
    @JsonProperty("bic")
    private String bic;
}
