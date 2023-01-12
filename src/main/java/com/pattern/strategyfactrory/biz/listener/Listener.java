package com.pattern.strategyfactrory.biz.listener;

import com.pattern.strategyfactrory.biz.context.TaskCallContext;

public interface Listener {

    void listener(TaskCallContext ctx);

}
