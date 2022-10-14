package com.pattern.strategyfactrory.error.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ErrorProxy implements InvocationHandler {

    @SuppressWarnings("unchecked")
    public static <T> T newProxyInstance(Class<T> klass) {
        return (T) Proxy.newProxyInstance(klass.getClassLoader(), new Class<?>[]{klass}, new ErrorProxy());
    }

    @Override
    public Object invoke(Object proxy, Method method, final Object[] args) throws Throwable {
        ErrorDef errorDef = method.getAnnotation(ErrorDef.class);
        if (errorDef == null) {
            return method.invoke(proxy, args);
        }

        final int httpStatusCode = errorDef.httpStatusCode();
        final int code = errorDef.code();
        String errorTypeName = errorDef.errorType().getTypeName();

        final String message;
        final String tagName = errorDef.tag().getTagName();
        if (errorDef.message().isEmpty()) {
            message = null;
        } else if (args == null || args.length == 0) {
            message = errorDef.showPrefix() ? errorTypeName + ", " + errorDef.message() : errorDef.message();
        } else {
            message = errorDef.showPrefix() ? errorTypeName + "," + formatMessage(errorDef.message(), args) :
            formatMessage(errorDef.message(), args);
        }
        return new ApplicationError() {
            private Error error = new Error(httpStatusCode, code, message, tagName);

            @Override
            public ErrorException exception() {
                return new ErrorException(this);
            }

            @Override
            public Error error() {
                return error;
            }

            @Override
            public String toString() {
                return error.toString();
            }
        };
    }

    private String formatMessage(String pattern, Object[] args) {
        if (pattern == null) {
            return null;
        }
        int index = 0;
        for (Object arg : args) {
            String argStr = "{null}";

            if (arg != null) {
                argStr = arg.toString();
            }

            pattern = pattern.replace("{" + index + "}", argStr);
            index++;
        }
        return pattern;
    }
}