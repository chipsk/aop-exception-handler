package com.pattern.strategyfactrory.error.base;

public class ErrorException extends RuntimeException {
    private ApplicationError error;

    public ErrorException(ApplicationError error) {
        super(error.error().getMessage());
        this.error = error;
    }

    public ApplicationError getError() {
        return error;
    }
}