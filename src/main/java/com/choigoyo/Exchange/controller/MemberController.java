package com.choigoyo.Exchange.controller;

import com.choigoyo.Exchange.DTO.UserDTO;
import com.choigoyo.Exchange.repository.UserRepository;
import com.choigoyo.Exchange.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RequiredArgsConstructor // 생성자 주입
@Controller
public class MemberController {
    private final UserRepository userRepository;
    private final MemberService memberService;

    // 회원가입 폼에서 이메일이 사용가능한 이메일인지 체크
    @PostMapping("/validateEmail")
    public @ResponseBody String validateEmail(@RequestParam("email") String email){
        return memberService.validateEmail(email);
    }

    @PostMapping("/member/save")
    public String memberSave(@ModelAttribute UserDTO userDTO){
        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + userDTO);
        memberService.save(userDTO); // service객체에 dto객체를 넘김
        return "redirect:/";
    }
}
