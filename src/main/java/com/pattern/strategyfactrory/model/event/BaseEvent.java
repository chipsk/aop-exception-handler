package com.pattern.strategyfactrory.model.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

import java.util.Date;
import java.util.UUID;


public class BaseEvent extends ApplicationEvent {
    private String trackUuid = UUID.randomUUID().toString();

    private Date createTime = new Date();

    private Boolean asyncEnable = true;


    public BaseEvent(Object source) {
        super(source);
    }

    public String getTrackUuid() {
        return trackUuid;
    }

    public void setTrackUuid(String trackUuid) {
        this.trackUuid = trackUuid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getAsyncEnable() {
        return asyncEnable;
    }

    public void setAsyncEnable(Boolean asyncEnable) {
        this.asyncEnable = asyncEnable;
    }
}
