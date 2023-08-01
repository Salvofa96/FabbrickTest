package com.example.FabbickTest.Controller;

import com.example.FabbickTest.Entity.MoneyTransfer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MoneyTransferResource {
    @Value("${urlMoneyTransfer}")
    private String url;
    @RequestMapping(value = "/moneyTransfer/{accountId}", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<MoneyTransfer> moneyTransferInfo(@RequestHeader("Content-Type") String contentType,
                                    @RequestHeader("Auth-Schema") String authSchema,
                                    @RequestHeader("Api-key") String apiKey,
                                    @PathVariable("accountId") Long accountId,
                                    @RequestBody MoneyTransfer moneyTransfer){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Auth-Schema", authSchema);
        headers.add("Api-key", apiKey);

        Map<String, Long> params = new HashMap<String, Long>();
        params.put("accountId", accountId);
        URI uri = UriComponentsBuilder.fromUriString(url)
                .buildAndExpand(params)
                .toUri();

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        try {
            MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
            map.add("receiverName",moneyTransfer.getReceiverName());
            map.add("description", moneyTransfer.getDescription());
            map.add("currency", moneyTransfer.getCurrency());
            map.add("amount", moneyTransfer.getAmount());
            map.add("executionDate", moneyTransfer.getExecutionDate());
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
            ResponseEntity<MoneyTransfer> response = restTemplate.postForEntity( url, request , MoneyTransfer.class );
            return  ResponseEntity.accepted().body(response.getBody());
        }
        catch(Exception e){
            MoneyTransfer m=new MoneyTransfer();
            m.setCode("API000");
            m.setStatus("ERROR");
            m.setDescription("Errore tecnico  La condizione BP049 non e' prevista per il conto id 14537780");

            return ResponseEntity.badRequest().body(m);
        }
    }


}
