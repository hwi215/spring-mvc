package com.example.spring.controller;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathVariableController {

    @RequestMapping("/user/jang.do")
    public void test(){
        System.out.println("PathVariableController test() call...");
    }


}
