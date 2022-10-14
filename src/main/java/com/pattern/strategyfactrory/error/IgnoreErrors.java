package com.pattern.strategyfactrory.error;

import com.pattern.strategyfactrory.error.base.BaseErrors;
import com.pattern.strategyfactrory.error.base.ErrorProxy;

public interface IgnoreErrors extends BaseErrors {
    IgnoreErrors INSTANCE = ErrorProxy.newProxyInstance(IgnoreErrors.class);

}