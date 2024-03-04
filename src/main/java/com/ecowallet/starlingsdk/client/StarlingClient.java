package com.ecowallet.starlingsdk.client;

import com.ecowallet.starlingsdk.models.response.FeedItemsResponse;
import com.ecowallet.starlingsdk.models.response.StarlingAccountIdentifier;
import com.ecowallet.starlingsdk.models.response.AccountsResponse;
import com.ecowallet.starlingsdk.models.response.StarlingBalance;
import com.ecowallet.starlingsdk.models.response.StarlingFeedItem;
import com.ecowallet.starlingsdk.models.response.StarlingToken;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface StarlingClient {

    @RequestLine("GET /feed/account/{account_id}/category/{category_id}?changesSince={changes_since}")
    @Headers({"Authorization: Bearer {token}"})
    FeedItemsResponse getFeedItems(@Param("token") String token, @Param("account_id") String accountId,
                                   @Param("category_id") String categoryId, @Param("changes_since") String changesSince);

    @RequestLine("GET /accounts")
    @Headers("Authorization: Bearer {token}")
    AccountsResponse getAccounts(@Param("token") String token);

    @RequestLine("GET /accounts/{id}/balance")
    @Headers("Authorization: Bearer {token}")
    StarlingBalance getBalance(@Param("token") String token, @Param("id") String id);

    @RequestLine("GET /accounts/{id}/identifiers")
    @Headers("Authorization: Bearer {token}")
    StarlingAccountIdentifier getAmount(@Param("token") String token, @Param("id") String id);

    @RequestLine("POST /oauth/access-token")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    StarlingToken getAccessToken(@Param("grant_type") String grantType, @Param("refresh_token") String refreshToken,
                                 @Param("client_id") String clientId,
                                 @Param("client_secret") String clientSecret);
}
