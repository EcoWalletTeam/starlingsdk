package com.ecowallet.starlingsdk.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedItemsResponse {
    @JsonProperty("feedItems")
    List<StarlingFeedItem> feedItems;
}
