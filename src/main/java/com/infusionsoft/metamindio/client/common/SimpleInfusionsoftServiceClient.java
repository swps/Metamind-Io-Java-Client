package com.infusionsoft.metamindio.client.common;

import com.google.common.base.Preconditions;
import com.infusionsoft.metamindio.client.common.authentication.FeignRequestAuthenticationStrategy;
import com.netflix.hystrix.Hystrix;

public class SimpleInfusionsoftServiceClient implements InfusionsoftServiceClient {
    private final FeignRequestAuthenticationStrategy authStrategy;
    private final ServiceLocation endpoint;
    private final String serviceName;

    public SimpleInfusionsoftServiceClient(FeignRequestAuthenticationStrategy authStrategy, ServiceLocation endpoint, String targetServiceName) {
        Preconditions.checkNotNull(authStrategy, "auth strategy");
        Preconditions.checkNotNull(endpoint, "service endpoint");
        Preconditions.checkNotNull(targetServiceName, "target service name");

        this.authStrategy = authStrategy;
        this.endpoint = endpoint;
        this.serviceName = targetServiceName;
    }

    @Override
    public FeignRequestAuthenticationStrategy getFeignAuthenticationStrategy() {
        return authStrategy;
    }

    @Override
    public ServiceLocation getServiceLocation() {
        return endpoint;
    }

    @Override
    public String getTargetServiceName() {
        return serviceName;
    }

    @Override
    public void reset() {
        Hystrix.reset();
    }
}
