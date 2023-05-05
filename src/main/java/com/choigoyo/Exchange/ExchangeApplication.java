package com.choigoyo.Exchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@EnableJpaAuditing
@SpringBootApplication
public class ExchangeApplication {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	} // 비밀번호 암호화

	public static void main(String[] args) {
		SpringApplication.run(ExchangeApplication.class, args);
	}

}
