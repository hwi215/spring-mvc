package com.example.spring.controller;

import com.example.spring.dto.MemberDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

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

    /**
     * 인수로 Dto 객체(command 객체)를 받으며
     * 그 객체의 정보가 뷰쪽으로 전달되어 뷰에서 사용할 수 있다.
     * view에서 사용하는 방법: 객체이름의 첫 글자를 소문자로 사용
     *   ex) ${memberDto.속성}
     *
     *
     * 인수로 @ModelAttribute("dto")를 선언하면,
     * 인수가 뷰로 전달될때 별칭을 만들어서 전달한다.
     * ${dto.속성
     */
    @RequestMapping("/user.do")
    public ModelAndView user(@ModelAttribute("dto") MemberDto member){ // MemberDto 모든 정보 다 들어옴

        System.out.println("member = " + member);

        // 서비스 -> dao

        // 결과를 받아서 뷰로 이동

        return new ModelAndView("ok");// 뷰의 이름이 ok -> /ok.jsp로 이동
    }

    @ModelAttribute("info")
    public String info(){
        return "오늘은 불금!!";
    }

    @ModelAttribute("hobbys")
    public List<String> hobbys(){
        return Arrays.asList("등산", "낚시");
    }


}
