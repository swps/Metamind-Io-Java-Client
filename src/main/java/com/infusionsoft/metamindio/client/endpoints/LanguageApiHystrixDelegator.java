package com.infusionsoft.metamindio.client.endpoints;

import com.infusionsoft.metamindio.client.model.*;
import com.infusionsoft.metamindio.client.common.FallbackCallback;

import com.google.common.base.Preconditions;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommand.Setter;

import javax.annotation.Nullable;


public class LanguageApiHystrixDelegator implements LanguageApi {
    private final LanguageApi.Resources delegate;
    private final Setter commandSetter;

    public LanguageApiHystrixDelegator(LanguageApi.Resources delegate, Setter commandSetter) {
        Preconditions.checkNotNull(delegate, "Resource delegate");
        Preconditions.checkNotNull(commandSetter, "Hystrix command setter");

        this.delegate = delegate;
        this.commandSetter = commandSetter;
    }


    public TextClassificationResponse classify (TextClassificationRequest body) {
        return classify (null , body);
    }

    public TextClassificationResponse classify (final @Nullable FallbackCallback<TextClassificationResponse > fallbackCallback, final TextClassificationRequest body) {

        final HystrixCommand<TextClassificationResponse > command = new HystrixCommand<TextClassificationResponse >(commandSetter) {
            @Override
            protected TextClassificationResponse run() throws Exception {
                return delegate.classify(body);
                }

            @Override
            protected TextClassificationResponse getFallback() {
                if(fallbackCallback == null) {
                    return super.getFallback();
                } else {
                    return fallbackCallback.doFallback();
                }
            }
        };

        return command.execute();
    }


    }

