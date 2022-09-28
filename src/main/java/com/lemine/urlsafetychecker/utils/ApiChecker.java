package com.lemine.urlsafetychecker.utils;

import com.lemine.urlsafetychecker.requests.GoogleCheckRequest;
import com.lemine.urlsafetychecker.requests.ThreatEntry;
import com.lemine.urlsafetychecker.requests.ThreatInfo;
import com.lemine.urlsafetychecker.responses.CheckResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ApiChecker {

    @Value("${google.safeBrowsingApiKey}")
    private String googleApiKey;
    private final String apiCallUrl = "https://safebrowsing.googleapis.com/v4/threatMatches:find?key=";


    public CheckResponse checkUrl(List<ThreatEntry> urls){
        RestTemplate restTemplate = new RestTemplate();
        GoogleCheckRequest googleCheckRequest = GoogleCheckRequest.builder()
                .threatInfo(ThreatInfo.builder()
                        .threatEntries(urls)
                        .build())
                .build();

        return  restTemplate.postForEntity(apiCallUrl+googleApiKey, googleCheckRequest, CheckResponse.class).getBody();

    }
}
