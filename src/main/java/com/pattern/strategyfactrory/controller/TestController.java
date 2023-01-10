package com.pattern.strategyfactrory.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @PostMapping("/strategy/doCall")
    public String doCall() {

        return "success";
    }

}
