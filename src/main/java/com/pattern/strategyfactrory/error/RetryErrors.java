package com.pattern.strategyfactrory.error;

import com.pattern.strategyfactrory.error.base.*;

import static com.pattern.strategyfactrory.error.base.ErrorTag.*;
import static com.pattern.strategyfactrory.error.base.ErrorType.*;

/**
 * 状态码规则 -400x
 */
public interface RetryErrors extends BaseErrors {
    RetryErrors INSTANCE = ErrorProxy.newProxyInstance(RetryErrors.class);

    @ErrorDef(httpStatusCode = 400, code = -400160, message = "业务执行异常拦截", errorType = BUSINESS_EXCEPTION, tag = RETRY)
    ApplicationError bizCallFilter();
}