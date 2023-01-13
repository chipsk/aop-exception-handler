package com.pattern.strategyfactrory.enums;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;


public enum BizCallStageEnum {

    INIT(-1, "初始化"),
    FILTER(0, "过滤"),
    EXECUTE(1, "执行"),
    POST_ACTION(2, "后置处理");

    private Integer state;

    private String content;

    BizCallStageEnum(Integer state, String content) {
        this.state = state;
        this.content = content;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static final Map<Integer, String> map = new HashMap<>() {{
        put(-1, "初始化");
        put(0, "过滤");
        put(1, "执行");
        put(2, "后置处理");
    }};


}
