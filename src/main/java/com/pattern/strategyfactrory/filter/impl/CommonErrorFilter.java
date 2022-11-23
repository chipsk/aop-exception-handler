package com.pattern.strategyfactrory.filter.impl;

import com.pattern.strategyfactrory.annotation.Filter;
import com.pattern.strategyfactrory.error.IgnoreErrors;
import com.pattern.strategyfactrory.filter.ErrorFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Filter
@Component
@Slf4j
public class CommonErrorFilter implements ErrorFilter {

    @Override
    public Boolean doFilter() {
        // test error
        boolean flag = true;
        if (flag) {
            // 异常类型为ignore，被aop捕获
            throw IgnoreErrors.INSTANCE.common("example error").exception();
        }
        return true;
    }

    @Override
    public void onFilter() {

    }
}
