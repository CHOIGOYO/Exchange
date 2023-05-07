package com.choigoyo.Exchange.config;

import com.choigoyo.Exchange.config.JWT.JwtAuthenticationFilter;
import com.choigoyo.Exchange.config.JWT.JwtAuthorizationFilter;
import com.choigoyo.Exchange.config.oauth.PrincipalOAuth2UserService;
import com.choigoyo.Exchange.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.filter.CorsFilter;

@RequiredArgsConstructor
@EnableWebSecurity /*스프링 시큐리티 필터(SecurityConfig)가 스프링 기본 필터체인에 등록*/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PrincipalOAuth2UserService principalOAuth2UserService;

    private final CorsFilter corsFilter;
    private final UserRepository userRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // csrf 비활성화
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // session을 사용하지 않는다
                .and()
                .oauth2Login()
                .loginPage("/signInForm")
                .userInfoEndpoint()
                .userService(principalOAuth2UserService);
        http.authorizeRequests()
                .antMatchers("/user/**").authenticated()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().permitAll() // "/user/**"와 "/admin/**" 주소 외의 요청은 인증 없이 접근 가능함.
                .and()
                .addFilter(corsFilter)
                .formLogin().disable()
                .httpBasic().disable()
                .addFilter(new JwtAuthenticationFilter(authenticationManager())) // filter 등록
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), userRepository))  // filter 등록
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }


}
