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
@Table(name = "File") // db에 생성될 테이블 이름
public class FileEntity extends BaseTimeEntity{
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 시퀀스의 역할 auto_increment
    @Column(name="id" , nullable = false)
    private Long id; // 파일 번호 아이디
    @Column(name="file_name" , nullable = false)
    private String file_name; // 파일 이름
    @Column(name="file_path" , nullable = false)
    private String file_path; // 파일 경로
    // 등록일자

    // 테이블 관계 N:1
    @ManyToOne
    @JoinColumn(name = "board_id")
    private BoardEntity board; // 어미글 ID
}
