package com.choigoyo.Exchange.service;

import com.choigoyo.Exchange.Entity.UserEntity;
import com.choigoyo.Exchange.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor // 생성자 주입 사용하기
@Service
public class MemberService {

    private final UserRepository userRepository;

    public String validateEmail(String email) {

        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity == null){
            return "ok";
        } else {
            return "no";
        }
    }
}
