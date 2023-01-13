package com.pattern.strategyfactrory.biz.context;

import com.pattern.strategyfactrory.enums.BizCallStageEnum;
import lombok.Data;

@Data
public abstract class CallContext {

    private Long leadId;

    private Long driverId;

    private String phone;

    private BizCallStageEnum stage;

    private String callerName;
}
