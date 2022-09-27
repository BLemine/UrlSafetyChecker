package com.lemine.urlsafetychecker.controllers;

import com.lemine.urlsafetychecker.controllers.constants.Paths;
import com.lemine.urlsafetychecker.controllers.requests.ThreatEntry;
import com.lemine.urlsafetychecker.controllers.responses.CheckResponse;
import com.lemine.urlsafetychecker.controllers.service.UrlCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class UrlChecker {

    @Autowired
    UrlCheckService urlCheckService;

    @PostMapping(Paths.SINGLE_LINK_CHECK)
    public CheckResponse checkSingleUrlSafety(@RequestBody ThreatEntry url){
        return urlCheckService.checkUrlSafety(Collections.singletonList(url));
    }

    @PostMapping(Paths.MULTIPLE_LINKS_CHECK)
    public CheckResponse checkMultipleUrlsSafety(@RequestBody List<ThreatEntry> urls){
        return urlCheckService.checkUrlSafety(urls);
    }

}
