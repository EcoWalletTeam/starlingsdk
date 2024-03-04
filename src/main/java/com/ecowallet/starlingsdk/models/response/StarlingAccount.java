package com.ecowallet.starlingsdk.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StarlingAccount {
    @JsonProperty("accountUid")
    private UUID accountUid;
    @JsonProperty("accountType")
    private String accountType;
    @JsonProperty("defaultCategory")
    private String defaultCategory;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("createdAt")
    private LocalDateTime createdAt;
    @JsonProperty("name")
    private String name;
}
