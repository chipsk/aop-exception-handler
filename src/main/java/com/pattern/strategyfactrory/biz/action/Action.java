package com.pattern.strategyfactrory.biz.action;

import com.pattern.strategyfactrory.biz.context.TaskCallContext;

public interface Action {

    void doAction(TaskCallContext ctx);
}
