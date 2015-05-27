package com.infusionsoft.metamindio.client.endpoints;

import com.infusionsoft.metamindio.client.MetamindIoService;
import com.infusionsoft.metamindio.client.common.InfusionsoftServiceClient;
import com.infusionsoft.metamindio.client.common.ServiceLocation;
import com.infusionsoft.metamindio.client.common.authentication.FeignRequestAuthenticationStrategy;
import com.netflix.hystrix.HystrixCommand.Setter;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;


public class MetamindIoServiceAssembler {

    private final InfusionsoftServiceClient serviceClient;

    public MetamindIoServiceAssembler(InfusionsoftServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    LanguageApi hystrixLanguageApi(){

            final FeignRequestAuthenticationStrategy auth = serviceClient.getFeignAuthenticationStrategy();
            final ServiceLocation serviceLocation = serviceClient.getServiceLocation();

            final LanguageApi.Resources delegate = auth.requestInterceptor(Feign.builder())
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .target(LanguageApi.Resources.class, serviceLocation.getEndpointUri().toString());

            final HystrixCommandGroupKey group = HystrixCommandGroupKey.Factory.asKey(serviceClient.getTargetServiceName());
            final HystrixThreadPoolKey threadPool = HystrixThreadPoolKey.Factory.asKey(serviceClient.getTargetServiceName());
            final HystrixCommandKey commandKey = HystrixCommandKey.Factory.asKey(LanguageApi.class.getSimpleName());

            final Setter tracksSetter = Setter.withGroupKey(group)
                .andThreadPoolKey(threadPool)
                .andCommandKey(commandKey);

            return new LanguageApiHystrixDelegator(delegate, tracksSetter);
    }
    public MetamindIoService createMetamindIoService(){
        MetamindIoService.Builder builder = MetamindIoService.builder();

        builder.withLanguageApi(hystrixLanguageApi());
        return builder.build();
    }

    public static MetamindIoService configureService(InfusionsoftServiceClient clientInfo){
        final MetamindIoServiceAssembler assembler = new MetamindIoServiceAssembler(clientInfo);
        return assembler.createMetamindIoService();
    }


}
