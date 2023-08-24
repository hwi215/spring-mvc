package com.example.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/", method = RequestMethod.GET)
public class HomeController {
    public String hello() {
        return "selectResult";
    }
}
