package com.example.spring.controller;

import com.example.spring.dto.MemberDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "/ajax.do")
    //@ResponseBody
    public List<MemberDto> aaa(String email, String pwd){
        System.out.println("email: " + email);
        System.out.println("pwd: " + pwd);

        System.out.println("나오나? ");
        List<MemberDto> list = new ArrayList<MemberDto>();
        list.add(new MemberDto("hwi", "이름", 22, "서울"));
        list.add(new MemberDto("hwi2", "이름", 32, "서울"));
        list.add(new MemberDto("hwi2", "이름", 42, "서울"));

        return list; // json 형태로 보내야 프론트가 받을 수 있음

    }


}
