package com.choigoyo.Exchange.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor // 기본 생성자가 생성
@AllArgsConstructor
@Table(name = "Board") // db에 생성될 테이블 이름
public class BoardEntity extends BaseTimeEntity{
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 시퀀스의 역할 auto_increment
    @Column(name="id" , nullable = false)
    private Long id; // 게시글 넘버
    @Column(name="title" , nullable = false,length = 100)
    private String title; // 제목
    @Column(name="content" , nullable = false)
    private String content; // 내용
    @Column(name="view_count")
    private Long view_count; // 조회수
    @Column(name="heart_count")
    private Long heart_count; // 하트 개수
    @Column(name="completion_date")
    private LocalDateTime completion_date; // 교환 완료일자

    // 테이블과의 관계 1:N
    @OneToMany(mappedBy = "board" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CommentEntity> comment = new ArrayList<>(); // 댓글
    @OneToMany(mappedBy = "board" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FileEntity> file = new ArrayList<>(); // 첨부파일
    @OneToMany(mappedBy = "board" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BoardTagMapEntity> Tag = new ArrayList<>(); // 해시태그
    @OneToMany(mappedBy = "board" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HeartEntity> heart = new ArrayList<>(); // 하트


    // 작성자 ID
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
