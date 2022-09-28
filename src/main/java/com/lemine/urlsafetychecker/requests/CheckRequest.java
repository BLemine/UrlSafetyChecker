package com.lemine.urlsafetychecker.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CheckRequest {
    private List<ThreatEntry> urls;
}
