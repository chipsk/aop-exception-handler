package com.pattern.strategyfactrory.biz.caller;

import com.pattern.strategyfactrory.biz.context.TaskCallContext;

public interface Caller {

    Boolean doCall(TaskCallContext ctx);

    Boolean onCallFail(TaskCallContext ctx);
}
