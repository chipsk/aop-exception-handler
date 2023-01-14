package com.pattern.strategyfactrory.biz.context;

import com.pattern.strategyfactrory.enums.BizCallStageEnum;
import lombok.Data;

@Data
public abstract class CallContext {

    private Long leadId;

    private Long driverId;

    private String phone;

    private BizCallStageEnum stage; //业务call进行阶段

    private String callerName;

    private Integer sourceId; //业务方id

    private String businessId; //业务id
}
