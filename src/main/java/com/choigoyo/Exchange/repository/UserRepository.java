package com.choigoyo.Exchange.repository;

import com.choigoyo.Exchange.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByEmail(String email); // JAP 쿼리 메서드

    UserEntity findByName(String name);

}
