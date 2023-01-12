package com.pattern.strategyfactrory.biz.action.impl;

import com.pattern.strategyfactrory.biz.action.Action;
import com.pattern.strategyfactrory.biz.context.TaskCallContext;
import org.springframework.stereotype.Component;

@Component
public class CallbackAction implements Action {

    @Override
    public void doAction(TaskCallContext ctx) {
        // callback
    }
}
