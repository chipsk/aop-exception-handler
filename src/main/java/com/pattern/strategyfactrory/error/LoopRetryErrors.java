package com.pattern.strategyfactrory.error;

import com.pattern.strategyfactrory.error.base.BaseErrors;
import com.pattern.strategyfactrory.error.base.ErrorProxy;

public interface LoopRetryErrors extends BaseErrors {
    LoopRetryErrors INSTANCE = ErrorProxy.newProxyInstance(LoopRetryErrors.class);

}