package com.infusionsoft.metamindio.client;

import com.infusionsoft.metamindio.client.endpoints.*;

/**
* A service facade representing the endpoints offered.
*/
public class MetamindIoService {
    public static final String INFUSIONSOFT_SERVICE_NAME = "Metamind.IO Service Client SDK";

    private LanguageApi languageApi;
    private MetamindIoService() {
    }


    /**
     * @return {@code LanguageApi } endpoint abstraction.
     */
    public LanguageApi getLanguageApi(){
        return languageApi;
    }
    public static class Builder{
        private final MetamindIoService building = new MetamindIoService();
        private Builder(){}

        public Builder withLanguageApi(LanguageApi languageApi){
            building.languageApi = languageApi;
            return this;
        }
        public MetamindIoService build(){
            return building;
        }
    }

    public static Builder builder(){
        return new Builder();
    }

}

