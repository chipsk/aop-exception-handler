package com.pattern.strategyfactrory.strategy;

import com.pattern.strategyfactrory.model.req.ErrorRequest;

public abstract class AbstractHandler {
    abstract public Object handle(ErrorRequest request);
}
