package com.choigoyo.Exchange.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private String role = "user"; // 역할 디폴트 user
    @Column(name ="address",nullable = true,length = 200)
    private String address; // 회원 주소
    @Column(name ="phone",nullable = true,length = 20)
    private String phone; // 회원 전화번호

    // 테이블과의 관계 1:N
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BoardEntity> board = new ArrayList<>(); // 게시글
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CommentEntity> comment = new ArrayList<>(); // 댓글
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HeartEntity> heart = new ArrayList<>(); // 하트
}
