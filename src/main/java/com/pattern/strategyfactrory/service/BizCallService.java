package com.pattern.strategyfactrory.service;

import com.alibaba.fastjson.JSONObject;
import com.pattern.strategyfactrory.model.req.ExecuteBizCallRequest;
import org.springframework.web.bind.annotation.RequestBody;

public interface BizCallService {

    Long ExecuteBizCall(ExecuteBizCallRequest request);
}
