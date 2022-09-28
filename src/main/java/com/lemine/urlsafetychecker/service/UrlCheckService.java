package com.lemine.urlsafetychecker.service;

import com.lemine.urlsafetychecker.requests.ThreatEntry;
import com.lemine.urlsafetychecker.responses.CheckResponse;

import java.util.List;

public interface UrlCheckService {
    CheckResponse checkUrlSafety(List<ThreatEntry> urls);
    boolean isUrlSafe(ThreatEntry url);
}
