package com.example.FabbickTest.Controller;

import com.example.FabbickTest.Entity.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
@Slf4j
@RestController
public class TransactionResource {
    @Value("${urlTransaction}")
    private String url;
    @GetMapping("/readingTransaction/{accountId}")
    ResponseEntity<Transaction> balanceReading(@RequestHeader("Content-Type") String contentType,
                                               @RequestHeader("Auth-Schema") String authSchema,
                                               @RequestHeader("Api-key") String apiKey, @PathVariable("accountId") Long accountId,
                                               @RequestParam("fromAccountingDate") String fromAccountingDate,
                                               @RequestParam("toAccountingDate") String toAccountingDate ){

        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("Auth-Schema", authSchema);
            headers.add("Api-key", apiKey);
            Map<String, String> params = new HashMap<String, String>();
            params.put("accountId", accountId.toString());
            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                    .queryParam("fromAccountingDate", fromAccountingDate)
                    .queryParam("toAccountingDate", toAccountingDate);
            URI uri = builder.buildAndExpand(params).toUri();
            HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
            ResponseEntity<Transaction> response =
                    restTemplate.exchange(uri, HttpMethod.GET, requestEntity, Transaction.class);

            log.info("Info Transazione");

            return ResponseEntity.accepted().body(response.getBody());
        } catch (Exception e){
            log.error("Transazione non reperibile",e);
            Transaction t=new Transaction();
            return ResponseEntity.badRequest().body(t);
        }


    }



}
