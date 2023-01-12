package com.pattern.strategyfactrory.biz.constructor.impl;

import com.pattern.strategyfactrory.biz.context.TaskCallContext;
import org.springframework.stereotype.Component;

@Component
public class BizConstructor extends AbstractConstructor {


    // BizConstructor 实现模版方法
    @Override
    protected boolean commonMethod(TaskCallContext ctx) {

        // do method

        return true;
    }
}
