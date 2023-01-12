package com.pattern.strategyfactrory.biz.preFilter;

import com.pattern.strategyfactrory.biz.context.TaskCallContext;

public interface PreFilter {

    // 预拦截
    Boolean doPreFilter(TaskCallContext ctx);
}
