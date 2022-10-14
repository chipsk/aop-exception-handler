package com.pattern.strategyfactrory.error.base;

public enum ErrorType {

    PARAM_EXCEPTION(1, "参数异常"),
    REQUEST_EXCEPTION(2, "三方请求异常"),
    BUSINESS_EXCEPTION(3, "业务规则异常");

    private Integer typeCode;
    private String typeName;

    ErrorType(Integer typeCode, String typeName) {
        this.typeCode = typeCode;
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }
    
}