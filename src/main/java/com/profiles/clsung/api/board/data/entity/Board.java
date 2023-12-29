package com.profiles.clsung.api.board.data.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "board")
public class Board {
    @Id
    @Column(name = "bbs_id")
    private String bbsId;
    @Column(name = "bbs_sj")
    private String bbsSj;
    @Column(name = "bbs_cn")
    private String bbsCn;
    @Column(name = "use_at")
    private String useAt;
    @Column(name = "register_id")
    private String registerId;
    @Column(name="regist_dt")
    private LocalDateTime registDt;
    @Column(name = "updusr_id")
    private String updusrId;
    @Column(name="updt_dt")
    private LocalDateTime updtDt;

    @Builder
    public Board(String bbsId, String bbsSj, String bbsCn, String useAt, String registerId,
                 LocalDateTime registDt, String updusrId, LocalDateTime updtDt) {
        this.bbsId = bbsId;
        this.bbsSj = bbsSj;
        this.bbsCn = bbsCn;
        this.useAt = useAt;
        this.registerId = registerId;
        this.registDt = registDt;
        this.updusrId = updusrId;
        this.updtDt = updtDt;
    }

    public void setBbsSj(String bbsSj){
        this.bbsSj = bbsSj;
    }

    public void setBbsCn(String bbsCn){
        this.bbsCn = bbsCn;
    }

    public void setUpdusrId(String updusrId){
        this.updusrId = updusrId;
    }

    public void setUpdtDt(LocalDateTime updtDt){
        this.updtDt = updtDt;
    }

}
