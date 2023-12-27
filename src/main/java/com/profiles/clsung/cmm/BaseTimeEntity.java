package com.profiles.clsung.cmm;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
    @Column(name = "regist_dt")
    @CreatedDate
    private LocalDateTime registDt;

    @Column(name = "updt_dt")
    @LastModifiedDate
    private LocalDateTime updtDt;
}
