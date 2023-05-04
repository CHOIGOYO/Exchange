package com.choigoyo.Exchange.config;

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

    private final CorsFilter corsFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); // csrf 비활성화
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // session을 사용하지 않는다
                .and()
                .addFilter(corsFilter)  // @CrossOrigin(인증 없을 때) , 시큐리티 필터에 등록(인증 있을 때)
                .formLogin().disable() // id pw 로그인을 form 로그인을 하지 X
                .httpBasic().disable()
                .authorizeRequests()
                .antMatchers("/user/**")
                .access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                .antMatchers("/admin/**")
                .access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll(); // 설정 외 모든 경로는 인증없이 접근가능
    }
}
