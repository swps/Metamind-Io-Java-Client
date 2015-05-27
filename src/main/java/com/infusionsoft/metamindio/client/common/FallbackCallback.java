package com.infusionsoft.metamindio.client.common;

/**
 * This interface is used to provide a graceful degradation for service calls which go badly.
 */
public interface FallbackCallback<T> {

    public T doFallback();

}

