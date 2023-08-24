package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 생성
public class RequestMappingController {

    @RequestMapping("/a.do")
    public ModelAndView aas(){
        System.out.println("a.do 요청됨..");

        // ModerAndView의 역할은 뷰쪽으로 전달될 데이터정보(Model) + 이동할 뷰 정보 설정
        ModelAndView mv = new ModelAndView();

        // 뷰에서 ${requestScope.message}로 호출 가능
        mv.addObject("message", "spring 배우기.");
        mv.setViewName("result"); // prefix + 뷰의 이름 + suffix
        return mv;


    }
}
