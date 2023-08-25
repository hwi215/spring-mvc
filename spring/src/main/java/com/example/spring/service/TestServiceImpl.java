package com.example.spring.service;


import org.springframework.stereotype.Service;

@Service // 생성 -> Bean Scanning 대상이 된다.
public class TestServiceImpl implements TestService{
    @Override
    public void test() {

    }
}
