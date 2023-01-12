package com.pattern.strategyfactrory.biz.listener.impl;

import com.pattern.strategyfactrory.biz.context.TaskCallContext;
import com.pattern.strategyfactrory.biz.listener.AbstractListener;
import com.pattern.strategyfactrory.model.event.BizDefaultEvent;

/**
 * 默认监听事件处理
 */
public class DefaultListener extends AbstractListener<BizDefaultEvent> {

    public void listener(TaskCallContext ctx) {

    }

    @Override
    protected void process(BizDefaultEvent event) {
        // listen event process

    }


}
