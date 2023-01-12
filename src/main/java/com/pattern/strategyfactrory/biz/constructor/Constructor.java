package com.pattern.strategyfactrory.biz.constructor;

import com.pattern.strategyfactrory.biz.context.TaskCallContext;

public interface Constructor {

    boolean constructor(TaskCallContext ctx);

}
