package com.lemine.urlsafetychecker.controllers.requests;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GoogleCheckRequest {
    private ThreatInfo threatInfo;
}
