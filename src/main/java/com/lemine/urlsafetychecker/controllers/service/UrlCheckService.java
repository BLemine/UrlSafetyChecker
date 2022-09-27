package com.lemine.urlsafetychecker.controllers.service;

import com.lemine.urlsafetychecker.controllers.requests.ThreatEntry;
import com.lemine.urlsafetychecker.controllers.responses.CheckResponse;

import java.util.List;

public interface UrlCheckService {
    CheckResponse checkUrlSafety(List<ThreatEntry> urls);
}
