package com.choigoyo.Exchange.Entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 1
@EntityListeners(AuditingEntityListener.class) // 2
public class BaseTimeEntity {

    @CreationTimestamp // 3
    @Column(updatable = false)
    private LocalDateTime localDateTime;

    @UpdateTimestamp // 4
    @Column(insertable = false)
    private LocalDateTime modifiedDate;
}