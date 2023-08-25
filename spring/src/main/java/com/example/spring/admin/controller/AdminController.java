package com.example.spring.admin.controller;

import com.example.spring.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {


    // 서비스가 필요함
   // @Autowired // @service 주입하기
    //private TestService testService;

    @RequestMapping("/test.admin")
    public String test(){
        System.out.println("AdminController Call..");

        //System.out.println("service: " + testService);

        return "result"; // WEB-INF/admin/result.jsp
    }
}
