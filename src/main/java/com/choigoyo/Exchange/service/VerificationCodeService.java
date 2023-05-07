package com.choigoyo.Exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class VerificationCodeService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void storeCode(String email, String code) {
        String key = "verification_code:" + email;
        stringRedisTemplate.opsForValue().set(key, code);
        stringRedisTemplate.expire(key, 10, TimeUnit.MINUTES); // 인증번호는 10분 후에 만료됩니다.
    }

    public boolean isCodeValid(String email, String code) {
        String key = "verification_code:" + email;
        String storedCode = stringRedisTemplate.opsForValue().get(key);
        return code.equals(storedCode);
    }
}

