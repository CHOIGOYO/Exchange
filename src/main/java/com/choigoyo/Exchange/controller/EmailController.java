package com.choigoyo.Exchange.controller;

import com.choigoyo.Exchange.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor // 생성자 주입 방식 사용
public class EmailController {
    private final EmailService emailService;
}
