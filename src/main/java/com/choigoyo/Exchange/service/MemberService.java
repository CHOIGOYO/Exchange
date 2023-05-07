package com.choigoyo.Exchange.service;

import com.choigoyo.Exchange.DTO.UserDTO;
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

    public void save(UserDTO userDTO) {
        // user DTO를 Entity로 변환
        UserEntity userEntity = userDTO.toEntity();
        // DB에 저장
        try {
            userRepository.save(userEntity);
            System.out.println("회원테이블 DB 저장");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
