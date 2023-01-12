package com.pattern.strategyfactrory.biz.filter.impl;

import com.pattern.strategyfactrory.biz.annotation.BizFilter;
import com.pattern.strategyfactrory.biz.context.TaskCallContext;
import com.pattern.strategyfactrory.biz.filter.Filter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 业务回调拦截
 */

@Component
@BizFilter
@Slf4j
public class BizCallbackFilter implements Filter {

    @Override
    public Boolean doFilter(TaskCallContext ctx) {
        return null;
    }

    @Override
    public void onFilter(TaskCallContext ctx) {

    }
}
