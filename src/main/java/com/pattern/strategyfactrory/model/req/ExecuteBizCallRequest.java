package com.pattern.strategyfactrory.model.req;

import lombok.Data;

@Data
public class ExecuteBizCallRequest {

    private Long leadId;

    private Long driverId;

    private String phone;

    private Integer sourceId;

    private String businessId;

}
