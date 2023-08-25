package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
//@Controller
public class ResponseBodyController {

    @RequestMapping("/responseBody.do")
    //@ResponseBody // 리턴하는 값을 그대로 응답객체로 브라우저에 전송
    public String aa(){
        System.out.println("ResponseBodyController aa() call...");
        return "success";

    }

    // 인코딩 추가
    @RequestMapping(value = "/responseBody2.do", produces = "text/html; charset=UTF-8")
    //@ResponseBody // 리턴하는 값을 그대로 응답객체로 브라우저에 전송
    public String aa2(){
        System.out.println("ResponseBodyController2 aa() call...");
        return "성공2";

    }
}
