package com.choigoyo.Exchange.config.oauth.provider;

import com.choigoyo.Exchange.repository.OAuth2UserInfo;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor // 기본생성자
public class GoogleUserInfo implements OAuth2UserInfo {

    private Map<String,Object> attributes; // getAttributes()
    
    public GoogleUserInfo(Map<String,Object> attributes){ // 생성자
        this.attributes = attributes;
    }
    @Override
    public String getProviderId() {
        return (String) attributes.get("sub");
    }

    @Override
    public String getProvider() {
        return "google";
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
