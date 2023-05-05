package com.choigoyo.Exchange.config.auth;

import com.choigoyo.Exchange.Entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;


@Data
@NoArgsConstructor // 기본 생성자
public class PrincipalDetails implements UserDetails, OAuth2User {

    private UserEntity user;
    private Map<String,Object> attributes;


    /**
     * 일반로그인 - 생성자*/
    public PrincipalDetails(UserEntity user) {
        this.user = user;
    }
    /**
     * OAuth로그인 - 생성자*/
    public PrincipalDetails(UserEntity user, Map<String,Object> attributes) {
        this.user = user;
        // attributes 정보를 같이 받는다.
        this.attributes = attributes;
    }

    @Override // OAuth2User
    public Map<String, Object> getAttributes() {
        return attributes;
    }
    @Override // OAuth2User
    public String getName() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // 사용자의 역할(role)을 가져와서 GrantedAuthority 객체를 생성하여 authorities 리스트에 추가
        String userRole = user.getRole();
        authorities.add(() -> userRole);

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
