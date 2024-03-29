package com.pattern.strategyfactrory.biz.caller.impl;


import com.pattern.strategyfactrory.biz.caller.Caller;
import com.pattern.strategyfactrory.biz.context.TaskCallContext;
import org.springframework.stereotype.Component;

@Component("singleCaller")
public class SingleCaller implements Caller {
    @Override
    public Boolean doCall(TaskCallContext ctx) {

        return false;
    }

    @Override
    public Boolean onCallFail(TaskCallContext ctx) {
        return false;
    }
}
