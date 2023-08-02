package com.example.FabbickTest.Controller;

import com.example.FabbickTest.Entity.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
@Slf4j
@RestController
public class BalanceReadingResource {

    @Value("${urlBalanceReading}")
    private String url;
    @GetMapping("/balanceReading/{accountId}")
    ResponseEntity<Root> balanceReading(@RequestHeader("Content-Type") String contentType, @RequestHeader("Auth-Schema") String authSchema,
                        @RequestHeader("Api-key") String apiKey, @PathVariable("accountId") Long accountId) {
        try{
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
            ResponseEntity<Root> response =
                    restTemplate.exchange(uri, HttpMethod.GET, requestEntity, Root.class);
            log.info("lettura saldo avvenuta");
            return ResponseEntity.accepted().body(response.getBody());
        } catch(Exception e){
            log.error("saldo non disponibile");
            Root r= new Root();
            r.setStatus("conto non trovato");
            return ResponseEntity.badRequest().body(r);
        }
    }

}
