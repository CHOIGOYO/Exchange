package com.choigoyo.Exchange.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor // 기본 생성자가 생성
@AllArgsConstructor
@Table(name = "Comment") // db에 생성될 테이블 이름
public class CommentEntity extends BaseTimeEntity{
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 시퀀스의 역할 auto_increment
    @Column(name="id" , nullable = false)
    private Long id; // 댓글 번호 아이디
    @Column(name="content" , nullable = false)
    private String content; // 댓글 내용

    // 테이블 관계 N:1
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user; // 작성자 ID

    @ManyToOne
    @JoinColumn(name = "board_id")
    private BoardEntity board; // 어미글 ID

    // 등록일자 , 수정일자 extends BaseTimeEntity
}
