package com.pattern.strategyfactrory.controller;

import com.alibaba.fastjson.JSONObject;
import com.pattern.strategyfactrory.model.req.ExecuteBizCallRequest;
import com.pattern.strategyfactrory.service.BizCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BizCallController {

    @Autowired
    private BizCallService bizCallService;

    @PostMapping("/executeBizCall")
    public String executeBizCall(@RequestBody String body) {
        ExecuteBizCallRequest request = JSONObject.parseObject(body, ExecuteBizCallRequest.class);
        bizCallService.ExecuteBizCall(request);
        return "success";
    }
}
