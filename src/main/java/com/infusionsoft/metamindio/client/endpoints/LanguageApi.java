package com.infusionsoft.metamindio.client.endpoints;

import com.infusionsoft.metamindio.client.common.FallbackCallback;

import feign.Headers;
import feign.RequestLine;

import javax.annotation.Nullable;
import javax.inject.Named;

import com.infusionsoft.metamindio.client.model.TextClassificationRequest;
import com.infusionsoft.metamindio.client.model.TextClassificationResponse;
/**
 * LanguageApi
 */
public interface LanguageApi {

  public TextClassificationResponse classify (TextClassificationRequest body) ;
  public TextClassificationResponse classify (@Nullable FallbackCallback<TextClassificationResponse > fallbackCallback, TextClassificationRequest body) ;

  interface Resources {

    // error info - code: 200 reason: "OK" model: TextClassificationResponse
    // error info - code: 401 reason: "Unauthorized" model: <none>
    // error info - code: 403 reason: "Forbidden" model: <none>
    // error info - code: 404 reason: "Not Found" model: <none>
    @RequestLine("GET /language/classify")
    public TextClassificationResponse classify (TextClassificationRequest body) ;

    }
}

