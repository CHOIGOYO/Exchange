package com.choigoyo.Exchange.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;


@RequiredArgsConstructor // 생성자 주입 사용하기
@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public String sendVerificationCode(String recipient) {
        String verificationCode = generateEmailCode();
        String subject = "Exchange 인증번호";
        String message = "인증번호는 " + verificationCode + " 입니다.";

        sendEmail(recipient, subject, message);
        return verificationCode; // 세션에 저장하기위해 반환
    }

    public void sendEmail(String recipient, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipient); // 수신자 설정
        message.setSubject(subject); // 제목 설정
        message.setText(text); // 내용 설정
        javaMailSender.send(message); // 메일 전송
    }

    /**
     * 이메일 인증번호를 생성하는 메서드
     *
     * @return 6자리 랜덤 알파벳 인증번호
     */
    public String generateEmailCode() {
        int codeLength = 6;  // 코드자리 6자리로 설정
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(codeLength);
        Random random = new SecureRandom();

        for (int i = 0; i < codeLength; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
