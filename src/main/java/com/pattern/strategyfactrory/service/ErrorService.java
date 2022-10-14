package com.pattern.strategyfactrory.service;

import com.pattern.strategyfactrory.req.ErrorRequest;

public interface ErrorService {

    Object handle(ErrorRequest request);


}
