package com.pattern.strategyfactrory.model;


import lombok.Data;

@Data
public class BizCallTask {

    private String taskName;

    private Integer constructorId;

    /**
     * 0未成 1进行中 2已完成 3已终止
     */
    private Integer status;

}
