package com.pattern.strategyfactrory.error.base;

import static com.pattern.strategyfactrory.error.base.ErrorType.*;
public interface BaseErrors {
  BaseErrors INSTANCE = ErrorProxy.newProxyInstance(BaseErrors.class);

  @ErrorDef(httpStatusCode = 400, code = -100, message = "{0}")
  ApplicationError common(String msg);

  @ErrorDef(httpStatusCode = 400, code = -101, message = "{0}参数为空", errorType = PARAM_EXCEPTION)
  ApplicationError isEmpty(String param);

}