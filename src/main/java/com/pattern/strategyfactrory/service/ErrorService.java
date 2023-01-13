package com.pattern.strategyfactrory.service;

import com.pattern.strategyfactrory.model.req.ErrorRequest;

public interface ErrorService {

    Object handle(ErrorRequest request);


}
