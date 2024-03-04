# Revolut SDK

This sdk is a library for interacting with Starling API for getting feed items, account information.

## How to use this sdk

```java
package com.ecowallet.starlingsdk;

import com.ecowallet.starlingsdk.client.StarlingClientDefault;
import com.ecowallet.starlingsdk.models.response.FeedItemsResponse;
import com.ecowallet.starlingsdk.models.response.StarlingAccount;
import com.ecowallet.starlingsdk.models.response.StarlingAccountIdentifier;
import com.ecowallet.starlingsdk.models.response.StarlingBalance;

import java.time.ZonedDateTime;
import java.util.List;

public class StarlingSdkExample {
    private static final ZonedDateTime lastYear = ZonedDateTime.now().minusYears(1L);

    public static void main(String[] args) {
        String clientSecret = "clientSecret";
        String clientId = "clientID";
        String refreshToken = "refreshToken";
        String baseUrl = "https://api-sandbox.starlingbank.com/api/v2/";
        String grantType = "refresh_token";
        StarlingClientDefault starlingClientDefault = StarlingClientDefault
                .builder()
                .baseUrl(baseUrl)
                .grantType(grantType)
                .refreshToken(refreshToken)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .build();
        List<StarlingAccount> accountList = starlingClientDefault.getStarlingAccounts().getAccountList();
        StarlingAccount mainAccount = accountList.getFirst();
        StarlingBalance balance = starlingClientDefault.getBalance(String.valueOf(mainAccount.getAccountUid()));
        StarlingAccountIdentifier accountIdentifier = starlingClientDefault.getAccountIdentifier(String.valueOf(mainAccount.getAccountUid()));
        FeedItemsResponse items = starlingClientDefault.getFeedItems(String.valueOf(accountList.getFirst().getAccountUid()), mainAccount.getDefaultCategory(), lastYear.toString());
    }
}

```
