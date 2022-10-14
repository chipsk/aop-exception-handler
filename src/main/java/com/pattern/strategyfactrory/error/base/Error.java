package com.pattern.strategyfactrory.error.base;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error {
    private int httpCode;
    private int code;
    private String message;
    private String tagName;

    @Override
    public String toString() {
        try {
            return JSON.toJSONString(this);
        } catch (Exception e) {
            return "Error: " + message + " code: " + code + " tagName: " + tagName;
        }
    }
}