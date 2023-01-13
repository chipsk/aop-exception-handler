package com.pattern.strategyfactrory.biz.caller.impl;


import com.pattern.strategyfactrory.biz.caller.Caller;
import com.pattern.strategyfactrory.biz.context.TaskCallContext;
import org.springframework.stereotype.Component;

@Component("groupCaller")
public class GroupCaller implements Caller {

    @Override
    public Boolean doCall(TaskCallContext ctx) {

        // do call

        return true;
    }

    @Override
    public Boolean onCallFail(TaskCallContext ctx) {
        return false;
    }
}
