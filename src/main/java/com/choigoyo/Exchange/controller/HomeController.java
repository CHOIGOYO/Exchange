package com.choigoyo.Exchange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // 기본 페이지 반환
    @GetMapping("/")
    public String index(){
        return "main/index";
    }

    // 회원가입 페이지 반환
    @GetMapping("/signInForm")
    public String signInForm(){
        return "views/signInForm";
    }

    // 로그인 페이지 반환
    @GetMapping("/loginForm")
    public String loginForm(){
        return "views/loginForm";
    }
}
