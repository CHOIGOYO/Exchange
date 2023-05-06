package com.choigoyo.Exchange.repository;

import com.choigoyo.Exchange.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {


    UserEntity findByEmail(String email);

    UserEntity findByName(String name);

}
