package com.choigoyo.Exchange.controller;

import com.choigoyo.Exchange.service.EmailService;
import com.choigoyo.Exchange.service.VerificationCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor // 생성자 주입 방식 사용
public class EmailController {
    private final EmailService emailService;
    private final VerificationCodeService verificationCodeService;

    @PostMapping("/signup/send-code")
    public ResponseEntity<String> sendVerificationCode(@RequestParam String email) {
        String code = emailService.sendVerificationCode(email);
        verificationCodeService.storeCode(email, code);
        return ResponseEntity.ok("Verification code sent to " + email);
    }

    @PostMapping("/signup/verify-code")
    public ResponseEntity<Boolean> verifyCode(@RequestParam String email, @RequestParam String code) {
        boolean isValid = verificationCodeService.isCodeValid(email, code);
        return ResponseEntity.ok(isValid);
    }

}
