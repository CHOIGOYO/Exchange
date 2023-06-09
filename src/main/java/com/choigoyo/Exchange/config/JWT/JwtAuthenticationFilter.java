package com.choigoyo.Exchange.config.JWT;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.choigoyo.Exchange.Entity.UserEntity;
import com.choigoyo.Exchange.config.auth.PrincipalDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("JwtAuthenticationFilter : 로그인 시도중...");
        try {
            // json 데이터를 파싱해줌
            ObjectMapper objectMapper = new ObjectMapper();
            UserEntity userEntity = objectMapper.readValue(request.getInputStream(), UserEntity.class);
            // 유저에 정보가 잘 담겼는지 print 해보기
            System.out.println(userEntity);
            // 토큰 생성(userName, password 를 담은)
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(userEntity.getName(),userEntity.getPassword());
            // authenticationManager.authenticate() 인증 수행하기
            // 그리고 PrincipalDetailsService 의 loadByUsername() 함수가 실행됨
            Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            System.out.println(request.getInputStream()); // request.getInputStream() 은 HttpServletRequest 객체로부터 입력 스트림을 가져오는 데 사용
            // 클라이언트 또는 다른 웹브라우저에서 서버로 전송된 데이터를 읽는데 사용할 수 있는 InputStream 객체
            // authenticate 객체가 session 영역에 저장됨
            PrincipalDetails principalDetails = (PrincipalDetails)authenticate.getPrincipal();
            System.out.println("==================로그인 완료=================="); // 구분선
            System.out.println("principalDetails userName :"+principalDetails.getUser().getName());
            System.out.println("==============================================="); // 구분선
            return authenticate;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        System.out.println("사용자 인증이 완료되어 successfulAuthentication 메서드가 실행됩니다.");

        PrincipalDetails principalDetails = (PrincipalDetails)authResult.getPrincipal();

        // 빌드패턴으로 토큰 생성하기
        String jwtToken = JWT.create()
                .withSubject("JWT-TOKEN")
                .withExpiresAt(new Date(System.currentTimeMillis() + (60000 * 10))) // 토큰의 유효시간을 10분으로 지정
                .withClaim("id", principalDetails.getUser().getId())
                .withClaim("username", principalDetails.getUser().getName())
                .sign(Algorithm.HMAC512("server-secret")); // server만 알고있는 secret값 으로 서명

        response.addHeader("Authentication","Bearer "+jwtToken);  // 사용자에게 응답

        System.out.println("==================토큰 생성==================");
        System.out.println("name : Authentication");
        System.out.println("value: Bearer "+ jwtToken);

    }
}
