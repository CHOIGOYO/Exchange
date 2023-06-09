package com.choigoyo.Exchange.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // 서버가 응답할 때 json 을 js 에서 처리할 수 있게 할지 설정
        config.addAllowedOrigin("*"); // 모든 ip에 응답 허용
        config.addExposedHeader("*"); //  모든 header 에 응답 허용
        config.addAllowedMethod("*"); // 모든 post ,get, delete , patch 요청을 허용
        source.registerCorsConfiguration("/**",config);
        return new CorsFilter(source);
    }

}
