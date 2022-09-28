package com.lemine.urlsafetychecker.requests;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ThreatInfo {
    private final String[] threatTypes={"MALWARE", "SOCIAL_ENGINEERING"};
    private final String[] platformTypes={"WINDOWS"};
    private final String[] threatEntryTypes={"URL"};
    private List<ThreatEntry> threatEntries;
}
