package com.infusionsoft.metamindio.client.common.authentication;

import feign.Feign.Builder;

/**
 * This interface is for applications to provide the appropriate authentication strategy for the
 * target service.  Implementations will add request interceptors to the Feign builder provided.
 */
public interface FeignRequestAuthenticationStrategy {

    public Builder requestInterceptor(Builder feign);

}

