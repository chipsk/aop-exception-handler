package com.pattern.strategyfactrory.error.base;

public enum ErrorTag {
    NO_RETRY(1, "不重试异常处理"),
    RETRY(2, "重试异常处理"),
    LOOP_RETRY(3, "循环重试异常处理"),
    IGNORE(4, "忽略异常处理");

    private Integer tagCode;
    private String tagName;

    ErrorTag(Integer tagCode, String tagName) {
        this.tagCode = tagCode;
        this.tagName = tagName;
    }

    public Integer getTagCode() {
        return tagCode;
    }

    public void setTagCode(Integer tagCode) {
        this.tagCode = tagCode;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}