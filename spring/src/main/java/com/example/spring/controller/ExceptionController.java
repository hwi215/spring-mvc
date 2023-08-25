package com.example.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ExceptionController {

    //private final Logger log = LoggerFactory.getLogger(getClass()); // @Slf4j 어노테이션 사용해도 됨

    @RequestMapping("/exception.do")
    public ModelAndView ex(String no){
        log.info("ExceptionController의.. ex call");

        int convertNo = Integer.parseInt(no);

        log.info("변환 결과 : " + convertNo);

        int result = 100 / convertNo;
        log.info("result = " + result);

        // WEB-INF/views/exResult.jsp로 이동 후, ${message}로 출력 가능
        return new ModelAndView("exResult", "message", "예외처리 실습중..");
    }

    @ExceptionHandler(value = {NumberFormatException.class, ArithmeticException.class}) // 예외처리
    public ModelAndView error(Exception ex){
        log.info("예외가 발생했습니다." + "ex.getMessage(): " + ex.getMessage());

        // 예외가 발생했을때, 해야할 일 작성
        ModelAndView mv = new ModelAndView();
        mv.addObject("errMsg", ex.getMessage());
        mv.addObject("errClass", ex.getClass().getName()); // 어떤 예외 클래스가 발생했는 지
        mv.setViewName("error/errorView");


        return mv;
    }
}
