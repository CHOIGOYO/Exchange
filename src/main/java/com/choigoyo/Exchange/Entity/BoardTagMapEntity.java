package com.choigoyo.Exchange.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor // 기본 생성자가 생성
@AllArgsConstructor
@Table(name = "BoardTagMap") // db에 생성될 테이블 이름
public class BoardTagMapEntity {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 시퀀스의 역할 auto_increment
    @Column(name="id" , nullable = false)
    private Long id;


    // 테이블 관계 1:N
    @ManyToOne
    @JoinColumn(name = "board_id")
    private BoardEntity board; // 어미글 ID

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private TagEntity tag;  // 해시 태그의 ID
}
