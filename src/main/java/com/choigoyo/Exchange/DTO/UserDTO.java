package com.choigoyo.Exchange.DTO;

import com.choigoyo.Exchange.Entity.UserEntity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String role;
    private Long postcode;
    private String roadAddress;
    private String jibunAddress;
    private String detailAddress;
    private String extraAddress;
    private String phone;
    private String provider;
    private String providerId;



    // 모든 필드를 인자로 받는 생성자
    public UserDTO(Long id, String email, String password, String name, String role,
                   Long postcode, String roadAddress, String jibunAddress, String detailAddress, String extraAddress,
                   String phone, String provider, String providerId) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
        this.postcode = postcode;
        this.roadAddress = roadAddress;
        this.jibunAddress = jibunAddress;
        this.detailAddress = detailAddress;
        this.extraAddress = extraAddress;
        this.phone = phone;
        this.provider = provider;
        this.providerId = providerId;
    }

    // UserEntity를 UserDTO로 변환하는 메소드
    public static UserDTO fromEntity(UserEntity userEntity) {
        return new UserDTO(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getName(),
                userEntity.getRole(),
                userEntity.getPostcode(),
                userEntity.getRoadAddress(),
                userEntity.getJibunAddress(),
                userEntity.getDetailAddress(),
                userEntity.getExtraAddress(),
                userEntity.getPhone(),
                userEntity.getProvider(),
                userEntity.getProviderId()
        );
    }

    // UserDTO를 UserEntity로 변환하는 메소드
    public UserEntity toEntity() {
        return UserEntity.builder()
                .id(id)
                .email(email)
                .password(password)
                .name(name)
                .role(role)
                .postcode(postcode)
                .roadAddress(roadAddress)
                .jibunAddress(jibunAddress)
                .detailAddress(detailAddress)
                .extraAddress(extraAddress)
                .phone(phone)
                .provider(provider)
                .providerId(providerId)
                .build();
    }


}

