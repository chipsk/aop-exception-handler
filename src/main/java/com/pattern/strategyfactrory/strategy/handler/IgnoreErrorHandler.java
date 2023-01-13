package com.pattern.strategyfactrory.strategy.handler;

import com.pattern.strategyfactrory.error.base.ErrorTag;
import com.pattern.strategyfactrory.model.req.ErrorRequest;
import com.pattern.strategyfactrory.strategy.AbstractHandler;
import com.pattern.strategyfactrory.strategy.HandlerType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@HandlerType(value = ErrorTag.IGNORE)
@Slf4j
public class IgnoreErrorHandler extends AbstractHandler {

    @Override
    public Object handle(ErrorRequest request) {
        System.out.println("ignoreError: " + request.getErrorException().toString());
        return null;
    }
}
