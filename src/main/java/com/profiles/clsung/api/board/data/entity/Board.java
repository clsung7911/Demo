package com.profiles.clsung.api.board.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "board")
public class Board {
    @Id
    @Column(name = "bbs_id")
    private String bbsId;
    @Column(name = "bbs_cn")
    private String bbsCn;
    @Column(name = "use_at")
    private String useAt;
    @Column(name = "register_id")
    private String registerId;
    @Column(name = "updusr_id")
    private String updusrId;

}
