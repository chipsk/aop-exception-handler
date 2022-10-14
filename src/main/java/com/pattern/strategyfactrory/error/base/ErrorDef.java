package com.pattern.strategyfactrory.error.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ErrorDef {
    int httpStatusCode() default 200;

    String message() default "";

    int code() default 0;

    boolean showPrefix() default false;

    ErrorType errorType() default ErrorType.BUSINESS_EXCEPTION;

    ErrorTag tag() default ErrorTag.IGNORE;
}