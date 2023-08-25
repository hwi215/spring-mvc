package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class TestController {
    private static final Logger logger =
            LoggerFactory.getLogger(ExceptionController.class);

    @RequestMapping("/test2.do")
    public ModelAndView ex(String no){
        System.out.println("/test2.do ");

        int convertNo = Integer.parseInt(no);

        logger.info("변환 결과 : " + convertNo);


        // WEB-INF/views/exResult.jsp로 이동 후, ${message}로 출력 가능
        return new ModelAndView("exResult", "message", "예외처리 실습중..");
    }
}
