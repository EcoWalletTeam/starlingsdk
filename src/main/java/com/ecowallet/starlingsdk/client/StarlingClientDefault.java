package com.ecowallet.starlingsdk.client;

import com.ecowallet.starlingsdk.models.response.FeedItemsResponse;
import com.ecowallet.starlingsdk.models.response.StarlingAccountIdentifier;
import com.ecowallet.starlingsdk.models.response.AccountsResponse;
import com.ecowallet.starlingsdk.models.response.StarlingBalance;
import com.ecowallet.starlingsdk.models.response.StarlingFeedItem;
import com.ecowallet.starlingsdk.models.response.StarlingToken;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import feign.Feign;
import feign.form.FormEncoder;
import feign.jackson.JacksonDecoder;
import lombok.Builder;
import lombok.extern.java.Log;

import java.util.Collections;
import java.util.List;

@Log
public class StarlingClientDefault {
    private static StarlingClient starlingClient;
    private final String baseUrl;
    private final String refreshToken;
    private final String grantType;
    private final String clientId;
    private final String clientSecret;

    @Builder
    private StarlingClientDefault(String baseUrl, String refreshToken, String grantType, String clientId,
                                  String clientSecret) {
        this.baseUrl = baseUrl;
        this.refreshToken = refreshToken;
        this.grantType = grantType;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        starlingClient = createFeignClientDefault();
    }

    public FeedItemsResponse getFeedItems(String accountId, String categoryId, String changesSince) {
        log.info("Looking up Transaction since " + changesSince + " for accountID " + accountId + " with categoryID " +
                categoryId);
        return starlingClient.getFeedItems(generateAccessToken(), accountId, categoryId, changesSince);
    }

    public AccountsResponse getStarlingAccounts() {
        log.info("Looking up accounts");
        return starlingClient.getAccounts(generateAccessToken());
    }

    public StarlingBalance getBalance(String id) {
        log.info("Looking up balance for account with id: " + id);
        return starlingClient.getBalance(generateAccessToken(), id);
    }

    public StarlingAccountIdentifier getAccountIdentifier(String id) {
        log.info("Looking up account identifier for account with id: " + id);
        return starlingClient.getAmount(generateAccessToken(), id);
    }

    public StarlingToken generateStarlingToken() {
        log.info("Generating starling token");
        StarlingClient starlingClientAuthClient = Feign.builder()
                .encoder(new FormEncoder())
                .decoder(new JacksonDecoder())
                .target(StarlingClient.class, "https://api-sandbox.starlingbank.com");
        return starlingClientAuthClient.getAccessToken(grantType, refreshToken, clientId, clientSecret);
    }
    
    public String generateAccessToken() {
        log.info("Generating access token");
        StarlingClient starlingClientAuthClient = Feign.builder()
                .encoder(new FormEncoder())
                .decoder(new JacksonDecoder())
                .target(StarlingClient.class, "https://api-sandbox.starlingbank.com");
        return starlingClientAuthClient.getAccessToken(grantType, refreshToken, clientId, clientSecret).getAccessToken();
    }
    

    private StarlingClient createFeignClientDefault() {
        return Feign.builder()
                .decoder(new JacksonDecoder(Collections.singleton(new JavaTimeModule())))
                .target(StarlingClient.class, baseUrl);
    }
}
