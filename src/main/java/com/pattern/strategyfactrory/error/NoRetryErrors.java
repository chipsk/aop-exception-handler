package com.pattern.strategyfactrory.error;

import com.pattern.strategyfactrory.error.base.BaseErrors;
import com.pattern.strategyfactrory.error.base.ErrorProxy;

public interface NoRetryErrors extends BaseErrors {
    NoRetryErrors INSTANCE = ErrorProxy.newProxyInstance(NoRetryErrors.class);

}