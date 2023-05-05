package com.choigoyo.Exchange.config.auth;

import com.choigoyo.Exchange.Entity.UserEntity;
import com.choigoyo.Exchange.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("PrincipalDetails 의 loadUserByUsername()");
        UserEntity userEntity = userRepository.findByName(username);
        return new PrincipalDetails(userEntity);
    }
}
