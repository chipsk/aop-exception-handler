package com.pattern.strategyfactrory.strategy.handler;

import com.pattern.strategyfactrory.error.base.ErrorTag;
import com.pattern.strategyfactrory.req.ErrorRequest;
import com.pattern.strategyfactrory.strategy.AbstractHandler;
import com.pattern.strategyfactrory.strategy.HandlerType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@HandlerType(value = ErrorTag.NO_RETRY)
@Slf4j
public class NoRetryErrorHandler extends AbstractHandler {
    @Override
    public Object handle(ErrorRequest request) {
        System.out.println("noRetryError: " + request.getErrorException().toString());
        return null;
    }
}
