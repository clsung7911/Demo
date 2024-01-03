package com.profiles.clsung.cmm.base;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Data
@MappedSuperclass
public class BaseSystemFieldEntity {
    @Column(name = "register_id", updatable = false)
    private String registerId;
    @Column(name = "regist_dt", updatable = false)
    private LocalDateTime registDt;
    @Column(name = "updusr_id")
    private String updusrId;
    @Column(name = "updt_dt")
    private LocalDateTime updtDt;

    @PrePersist
    protected void onCreate(){
        this.registDt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updtDt = LocalDateTime.now();
    }
}
