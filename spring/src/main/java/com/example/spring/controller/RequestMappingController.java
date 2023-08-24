package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller // 생성
@RequestMapping("/rem")
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

    /**
     * 여러개의 요청이 하나의 메소드를 호출해줌
     *
     * @return : String인 경우는, 리턴된 문자열이 뷰의 이름이 된다.
     */
    @RequestMapping(value = {"/b.do", "/c.do"})
    public String bb(){
        System.out.println("b.do와 c.do 요청됨....");
        return "result"; // WEB-INF/views/result.jsp
    }

    /**
     * @return : void인 경우는, 요청된 URL 주소가 뷰 이름이 된다.
     * ex) rem/test.do 요청시 뷰의 이름은 rem/test가 된다.
     * -> WEB-INF/views/rem/test.jsp
     */
    /*
    @RequestMapping("/test.do")
    public void test(HttpServletRequest request){
        System.out.println("rem/test.do 요청됨...");

        String name = request.getParameter("name");
        System.out.println("name: " + name);
    }

     */

    @GetMapping("/test.do")
    public void test(HttpServletRequest request){
        System.out.println("rem/test.do Get 요청됨...");

        String name = request.getParameter("name");
        System.out.println("name: " + name);
    }

    @PostMapping("/test.do")
    public void test2(HttpServletRequest request){
        System.out.println("rem/test.do Post 요청됨...");

        String name = request.getParameter("name");
        System.out.println("name: " + name);
    }

}
