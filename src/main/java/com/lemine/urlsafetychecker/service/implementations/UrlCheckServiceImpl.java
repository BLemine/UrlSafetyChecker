package com.lemine.urlsafetychecker.service.implementations;

import com.lemine.urlsafetychecker.requests.ThreatEntry;
import com.lemine.urlsafetychecker.responses.CheckResponse;
import com.lemine.urlsafetychecker.service.UrlCheckService;
import com.lemine.urlsafetychecker.utils.ApiChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UrlCheckServiceImpl implements UrlCheckService {

    @Autowired
    private ApiChecker checker;

    @Override
    public CheckResponse checkUrlSafety(List<ThreatEntry> urls) {
        return checker.checkUrl(urls);
    }

    @Override
    public boolean isUrlSafe(ThreatEntry url) {
        return checker.checkUrl(Collections.singletonList(url)).getThreatMatches() == null;
    }
}
