package com.pattern.strategyfactrory.biz.action.impl;

import com.pattern.strategyfactrory.biz.action.Action;
import com.pattern.strategyfactrory.biz.context.TaskCallContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(-1)
public class SaveRecordAction implements Action {

    @Override
    public void doAction(TaskCallContext ctx) {
        // save record
    }
}
