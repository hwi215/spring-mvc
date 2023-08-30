package com.example.spring.controller;

import com.example.spring.service.TestService;
import com.example.spring.service.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PathVariableController {
    // 서비스가 필요함
    @Autowired // @service 주입하기
    private TestService testService;

    @RequestMapping("/{type}/{id}.do")
    public void test(@PathVariable String type, @PathVariable String id){  // 요청을 해로 잘 받기
        System.out.println("PathVariableController test() call...");

        System.out.println("type: " + type);
        System.out.println("id: " + id);

        System.out.println("testService: " + testService);
    }

    @RequestMapping("/{userId}")
    public String test2(@PathVariable String userId){
        return "result";

    }

    @RequestMapping("/borad/{name}/{num}")
    public String test2(@PathVariable String name, @PathVariable int num){
        System.out.println("name: " + name);
        System.out.println("num: " + num);

        //return "result";
        return "redirect:/rem/a.do"; // "/rem/a.do" 요청의 컨트롤러에 진입하게 됨


    }


}
