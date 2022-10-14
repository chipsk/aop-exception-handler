package com.pattern.strategyfactrory.strategy;

import com.pattern.strategyfactrory.error.base.ErrorTag;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface HandlerType {
    ErrorTag value() default ErrorTag.IGNORE;
}
