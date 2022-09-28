package com.lemine.urlsafetychecker.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThreatMatch {
    private String threatType;
    private String platformType;
    private Threat threat;
    private String threatEntryType;
}
