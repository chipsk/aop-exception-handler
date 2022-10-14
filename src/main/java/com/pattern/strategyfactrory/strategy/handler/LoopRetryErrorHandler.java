package com.pattern.strategyfactrory.strategy.handler;

import com.pattern.strategyfactrory.error.base.ErrorTag;
import com.pattern.strategyfactrory.req.ErrorRequest;
import com.pattern.strategyfactrory.strategy.AbstractHandler;
import com.pattern.strategyfactrory.strategy.HandlerType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@HandlerType(value = ErrorTag.LOOP_RETRY)
@Slf4j
public class LoopRetryErrorHandler extends AbstractHandler {

    @Override
    public Object handle(ErrorRequest request) {
        System.out.println("loopRetryError: " + request.getErrorException().toString());
        return null;
    }
}
