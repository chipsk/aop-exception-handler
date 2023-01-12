package com.pattern.strategyfactrory.biz.caller.impl;


import com.pattern.strategyfactrory.biz.caller.Caller;
import com.pattern.strategyfactrory.biz.context.TaskCallContext;
import org.springframework.stereotype.Component;

@Component("groupCaller")
public class GroupCaller implements Caller {

    @Override
    public boolean doCall(TaskCallContext ctx) {

        // do call

        return true;
    }

    @Override
    public boolean onCallFail(TaskCallContext ctx) {
        return false;
    }
}
