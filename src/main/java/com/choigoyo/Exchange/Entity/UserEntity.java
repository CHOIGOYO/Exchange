package com.choigoyo.Exchange.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "User")
public class UserEntity extends BaseTimeEntity{
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 시퀀스의 역할 auto_increment
    @Column(name="id" , nullable = false)
    private Long id; // 회원번호 아이디
    @Column(name ="email",nullable = false , unique = true ,length = 50)
    private String email; // 회원 이메일
    @Column(name ="password",nullable = false,length = 100)
    private String password; // 회원 비밀번호
    @Column(name ="name",nullable = false,length = 50)
    private String name; // 회원 이름
    @Column(name ="role",nullable = false)
    private String role = "ROLE_USER"; // 역할 디폴트 user
    @Column(name ="postcode",nullable = true,length = 20)
    private Long postcode; // 회원 우편번호
    @Column(name ="roadAddress",nullable = true,length = 200)
    private String roadAddress; // 회원 도로명 주소
    @Column(name ="jibunAddress",nullable = true,length = 200)
    private String jibunAddress; // 회원 지번 주소
    @Column(name ="detailAddress",nullable = true,length = 200)
    private String detailAddress; // 회원 상세 주소
    @Column(name ="extraAddress",nullable = true,length = 200)
    private String extraAddress; // 회원 주소참고
    @Column(name ="phone",nullable = true,length = 20)
    private String phone; // 회원 전화번호


    // oauth 로그인을 한 사용자와 일반 사용자의 구분을 위해 추가
    @Column(name ="provider", unique = true ,length = 50)
    private String provider; //
    @Column(name ="providerId", unique = true ,length = 50)
    private String providerId; //

    // 테이블과의 관계 1:N
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BoardEntity> board = new ArrayList<>(); // 게시글
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CommentEntity> comment = new ArrayList<>(); // 댓글
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HeartEntity> heart = new ArrayList<>(); // 하트

    @Builder
    public UserEntity(Long id, String email, String password, String name, String role,
                      Long postcode, String roadAddress, String jibunAddress, String detailAddress, String extraAddress,
                      String phone, String provider, String providerId, List<BoardEntity> board, List<CommentEntity> comment, List<HeartEntity> heart) {
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
        this.board = board;
        this.comment = comment;
        this.heart = heart;
    }


}
