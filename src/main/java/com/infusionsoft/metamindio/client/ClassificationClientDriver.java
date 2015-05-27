package com.infusionsoft.metamindio.client;

import com.infusionsoft.metamindio.client.common.InfusionsoftServiceClient;
import com.infusionsoft.metamindio.client.common.ServiceLocation;
import com.infusionsoft.metamindio.client.common.SimpleInfusionsoftServiceClient;
import com.infusionsoft.metamindio.client.common.authentication.BasicAuthCredentials;
import com.infusionsoft.metamindio.client.common.authentication.BasicAuthFeignRequestAuthenticationStrategy;
import com.infusionsoft.metamindio.client.common.authentication.FeignRequestAuthenticationStrategy;
import com.infusionsoft.metamindio.client.endpoints.MetamindIoServiceAssembler;
import com.infusionsoft.metamindio.client.model.TextClassificationRequest;
import com.infusionsoft.metamindio.client.model.TextClassificationResponse;

import java.net.URI;

/**
 * Created by wendel.schultz on 5/27/15.
 */
public class ClassificationClientDriver {

    public static void main (String[] args) {
        final String serviceName = "ClassificationClientDriver";
        final URI metamindUri = URI.create("https://www.metamind.io");
//        final URI metamindUri = URI.create("http://localhost:5005");

//        final FeignRequestAuthenticationStrategy authStrategy = AuthenticationHeaderFeignRequestAuthenticationStrategy.usingAuthorizationToken()
        final BasicAuthCredentials credentials = new BasicAuthCredentials("wendel.schultz@gmail.com", "bonehead");
        final FeignRequestAuthenticationStrategy authStrategy = new BasicAuthFeignRequestAuthenticationStrategy(credentials);

        final ServiceLocation endpoint = new ServiceLocation(metamindUri);

        InfusionsoftServiceClient client = new SimpleInfusionsoftServiceClient(authStrategy, endpoint, serviceName);
        MetamindIoService service = MetamindIoServiceAssembler.configureService(client);


        TextClassificationRequest classifyMe = new TextClassificationRequest();
        classifyMe.setClassifierId(155L);
        classifyMe.setValue("This movie is so great");

        TextClassificationResponse classified = service.getLanguageApi().classify(classifyMe);

        System.out.println("Classified: " + classifyMe.getValue());
        System.out.println("Response: " + classified);

    }
}
