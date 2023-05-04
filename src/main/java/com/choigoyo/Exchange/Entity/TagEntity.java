package com.choigoyo.Exchange.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor // 기본 생성자가 생성
@AllArgsConstructor
@Table(name = "Tag") // db에 생성될 테이블 이름
public class TagEntity {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 시퀀스의 역할 auto_increment
    @Column(name="id" , nullable = false)
    private Long id; // 태그 번호 아이디
    @Column(name="Tag_name")
    private String Tag_name; // 태그 이름

    // 테이블 관계 N:1
    @OneToMany(mappedBy = "tag" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BoardTagMapEntity> Tag = new ArrayList<>(); // 해시태그
}
