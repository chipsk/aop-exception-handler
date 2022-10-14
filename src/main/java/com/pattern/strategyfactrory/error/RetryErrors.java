package com.pattern.strategyfactrory.error;

import com.pattern.strategyfactrory.error.base.BaseErrors;
import com.pattern.strategyfactrory.error.base.ErrorProxy;

public interface RetryErrors extends BaseErrors {
    RetryErrors INSTANCE = ErrorProxy.newProxyInstance(RetryErrors.class);
}