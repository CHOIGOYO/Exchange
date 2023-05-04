package com.choigoyo.Exchange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //    기본페이지 반환
    @GetMapping("/")
    public String index(){
        return "main/index";
    }
}
