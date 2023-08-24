package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
     */
    @RequestMapping("/b.do")
    public void bbb(@RequestParam(defaultValue = "Guest") String id,
                    @RequestParam(defaultValue = "0") int age){ // 들어온 값이 null이면 기본값 설정
        System.out.println("id = " + id);
        System.out.println("age = " + age);
    }


}
