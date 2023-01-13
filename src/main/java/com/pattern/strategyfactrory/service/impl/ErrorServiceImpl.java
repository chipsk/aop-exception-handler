package com.pattern.strategyfactrory.service.impl;

import com.pattern.strategyfactrory.error.base.ErrorException;
import com.pattern.strategyfactrory.model.req.ErrorRequest;
import com.pattern.strategyfactrory.service.ErrorService;
import com.pattern.strategyfactrory.strategy.AbstractHandler;
import com.pattern.strategyfactrory.strategy.HandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class ErrorServiceImpl implements ErrorService {

    @Resource
    private HandlerContext handlerContext;

    @Override
    public Object handle(ErrorRequest request) {
        ErrorException error = request.getErrorException();
        AbstractHandler handler = handlerContext.getInstance(error);
        return handler.handle(request);
    }
}
