package com.choigoyo.Exchange.config.oauth.provider;

import com.choigoyo.Exchange.repository.OAuth2UserInfo;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor // 기본생성자
public class NaverUserInfo implements OAuth2UserInfo {

    // USER-Request-getAttributes :{resultcode=00, message=success, response={id=아이디값, email=회원 이메일, name=회원이름}
    private Map<String,Object> attributes; // getAttributes()

    public NaverUserInfo(Map<String,Object> attributes){ // 생성자
        this.attributes = attributes;
    }
    @Override
    public String getProviderId() {
        return (String) attributes.get("id");
    }

    @Override
    public String getProvider() {
        return "naver";
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }
}
