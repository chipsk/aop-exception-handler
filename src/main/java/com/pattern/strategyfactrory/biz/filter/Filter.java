package com.pattern.strategyfactrory.biz.filter;

import com.pattern.strategyfactrory.biz.context.TaskCallContext;

public interface Filter {

    // 拦截
    Boolean doFilter(TaskCallContext ctx);

    // 被拦截时
    void onFilter(TaskCallContext ctx);
}
