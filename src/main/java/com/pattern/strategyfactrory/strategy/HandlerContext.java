package com.pattern.strategyfactrory.strategy;

import com.pattern.strategyfactrory.error.base.ErrorException;
import com.pattern.strategyfactrory.utils.SpringContextUtils;

import java.util.Map;

public class HandlerContext {
    private Map<String, Class> handlerMap;

    public HandlerContext(Map<String, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public AbstractHandler getInstance(ErrorException error) {
        String tagName = error.getError().error().getTagName();

        Class clazz = handlerMap.get(tagName);
        if (clazz == null) {
            //如果没有找到对应的handler，则直接抛出该异常
            throw error.getError().exception();
        }
        return (AbstractHandler) SpringContextUtils.getBean(clazz);
    }
}
