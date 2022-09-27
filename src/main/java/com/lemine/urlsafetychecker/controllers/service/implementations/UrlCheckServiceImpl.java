package com.lemine.urlsafetychecker.controllers.service.implementations;

import com.lemine.urlsafetychecker.controllers.requests.GoogleCheckRequest;
import com.lemine.urlsafetychecker.controllers.requests.ThreatEntry;
import com.lemine.urlsafetychecker.controllers.requests.ThreatInfo;
import com.lemine.urlsafetychecker.controllers.responses.CheckResponse;
import com.lemine.urlsafetychecker.controllers.service.UrlCheckService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UrlCheckServiceImpl implements UrlCheckService {

    @Value("${google.safeBrowsingApiKey}")
    private String googleApiKey;
    private final String apiCallUrl = "https://safebrowsing.googleapis.com/v4/threatMatches:find?key=";

    @Override
    public CheckResponse checkUrlSafety(List<ThreatEntry> urls) {
        RestTemplate restTemplate = new RestTemplate();
        GoogleCheckRequest googleCheckRequest = GoogleCheckRequest.builder()
                .threatInfo(ThreatInfo.builder()
                        .threatEntries(urls)
                        .build())
                .build();

        return restTemplate.postForEntity(apiCallUrl+googleApiKey, googleCheckRequest, CheckResponse.class).getBody();
    }
}
