package com.pattern.strategyfactrory.biz.caller;

import com.pattern.strategyfactrory.biz.context.TaskCallContext;

public interface Caller {

    boolean doCall(TaskCallContext ctx);

    boolean onCallFail(TaskCallContext ctx);
}
