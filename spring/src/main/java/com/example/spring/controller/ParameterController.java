package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller // 생성
@RequestMapping("/param")
public class ParameterController {

    /*
    @RequestMapping("/a.do")
    public String aa(String name, int age){

        System.out.println("param/do.do 호출됨");
        System.out.println("name = " + name);
        System.out.println("age =  " + age);

        return "result"; // ~result.jsp
    }

     */

    @RequestMapping("/a.do")
    public String aa(String name, int age){

        System.out.println("param/do.do 호출됨");
        System.out.println("name = " + name);
        System.out.println("age =  " + age);

        return "result"; // ~result.jsp
    }

    /**
     * void는 요청주소가 뷰이름이 된다
     * ex) param/b.do 이면 /WEB-INF/views/params/b.jsp
     *
     * 리턴이 void이거나, String일때 view정보만 전달되는데,
     * Model정보도 함께 전달하고 싶을 때 Model을 인수로 받는다.
     */

    /*
    @RequestMapping("/c.do")
    public String cc(
            @RequestParam(defaultValue = "Guest", value = "userId") String id){ // value = "프론트에서 넘어오는 id값"
        System.out.println("id = " + id);

        return "param/b";
    }

     */

    @RequestMapping("/c.do")
    public String cc2( // value = "프론트에서 넘어오는 id값"
            @RequestParam(defaultValue = "Guest", value = "userId") String id, Model model){
        System.out.println("id = " + id);

        // model에 정보 저장하기
        model.addAttribute("message", "Spring MVC");
        model.addAttribute("menu", Arrays.asList("짜장", "짬뽕", "탕수육"));



        return "param/b";
    }



}
