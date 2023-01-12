package com.pattern.strategyfactrory.biz.context;

import lombok.Data;

@Data
public abstract class CallContext {

    private Long leadId;

    private Long driverId;

    private String phone;
}
