package com.ecowallet.starlingsdk.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StarlingFeedItem {
    @JsonProperty("feedItemUid")
    private String feedItemUid;
    @JsonProperty("categoryUid")
    private String categoryUid;
    @JsonProperty("amount")
    private StarlingAmount amount;
    @JsonProperty("sourceAmount")
    private StarlingAmount sourceAmount;
    @JsonProperty("direction")
    private String direction;
    @JsonProperty("updatedAt")
    private LocalDateTime updatedAt;
    @JsonProperty("transactionTime")
    private LocalDateTime transactionTime;
    @JsonProperty("settlementTime")
    private LocalDateTime settlementTime;
    @JsonProperty("source")
    private String source;
    @JsonProperty("sourceSubType")
    private String sourceSubType;
    @JsonProperty("status")
    private String status;
    @JsonProperty("counterPartyType")
    private String counterPartyType;
    @JsonProperty("counterPartyUid")
    private String counterPartyUid;
    @JsonProperty("counterPartyName")
    private String counterPartyName;
    @JsonProperty("counterPartySubEntityUid")
    private String counterPartySubEntityUid;
    @JsonProperty("counterPartySubEntityName")
    private String counterPartySubEntityName;
    @JsonProperty("counterPartySubEntityIdentifier")
    private String counterPartySubEntityIdentifier;
    @JsonProperty("counterPartySubEntitySubIdentifier")
    private String counterPartySubEntitySubIdentifier;
    @JsonProperty("reference")
    private String reference;
    @JsonProperty("country")
    private String country;
    @JsonProperty("spendingCategory")
    private String spendingCategory;
    @JsonProperty("userNote")
    private String userNote;
    @JsonProperty("hasAttachment")
    private Boolean hasAttachment;
}
