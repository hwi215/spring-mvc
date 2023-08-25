package com.example.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {
    private static final Logger logger =
            LoggerFactory.getLogger(ExceptionController.class);

    @RequestMapping("/exception.do")
    public ModelAndView ex(String no){
        logger.info("ExceptionController의.. ex call");

        int convertNo = Integer.parseInt(no);

        logger.info("변환 결과 : " + convertNo);

        int result = 100 / convertNo;
        logger.info("result = " + result);

        // WEB-INF/views/exResult.jsp로 이동 후, ${message}로 출력 가능
        return new ModelAndView("exResult", "message", "예외처리 실습중..");
    }

    @ExceptionHandler(value = {NumberFormatException.class, ArithmeticException.class}) // 예외처리
    public ModelAndView error(Exception ex){
        logger.info("예외가 발생했습니다." + "ex.getMessage(): " + ex.getMessage());

        // 예외가 발생했을때, 해야할 일 작성
        ModelAndView mv = new ModelAndView();
        mv.addObject("errMsg", ex.getMessage());
        mv.addObject("errClass", ex.getClass().getName()); // 어떤 예외 클래스가 발생했는 지
        mv.setViewName("error/errorView");


        return mv;
    }
}
