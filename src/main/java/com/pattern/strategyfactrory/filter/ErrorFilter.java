package com.pattern.strategyfactrory.filter;

public interface ErrorFilter {
    // 判断是否要拦截
    Boolean doFilter();

    // 被拦截时
    void onFilter();
}
