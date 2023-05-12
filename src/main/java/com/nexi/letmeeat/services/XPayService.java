package com.nexi.letmeeat.services;

import antlr.StringUtils;
import com.nexi.letmeeat.resoruces.PayByLinkRequest;
import com.nexi.letmeeat.resoruces.PayByLinkResponse;
import com.nexi.letmeeat.resoruces.PaymentRedirectResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.UUID;

@Service
public class XPayService {

    public PaymentRedirectResponse payByLink(PayByLinkRequest payByLinkRequest){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Api-Key", "06aa13b7-bdeb-4c7a-b4ef-4e8050f6ae7c");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Correlation-Id", UUID.randomUUID().toString());

        HttpEntity<PayByLinkRequest> entity = new HttpEntity<>(payByLinkRequest, headers);

        ResponseEntity<PayByLinkResponse> response = restTemplate.exchange(
                "https://xpaysandbox.nexigroup.com/api/phoenix-0.0/psp/api/v1/orders/paybylink",
                HttpMethod.POST,
                entity,
                PayByLinkResponse.class);

        return new PaymentRedirectResponse(response.getBody().getPaymentLink().getLink());
    }

}
