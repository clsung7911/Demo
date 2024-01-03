package com.profiles.clsung.api.board.data.entity;

import com.profiles.clsung.cmm.base.BaseSystemFieldEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "board")
public class Board extends BaseSystemFieldEntity {
    @Id
    @Column(name = "bbs_id")
    private String bbsId;
    @Column(name = "bbs_sj")
    private String bbsSj;
    @Column(name = "bbs_cn")
    private String bbsCn;
    @Column(name = "use_at")
    private String useAt;

    @Builder
    public Board(String bbsId, String bbsSj, String bbsCn, String useAt) {

        this.bbsId = bbsId;
        this.bbsSj = bbsSj;
        this.bbsCn = bbsCn;
        this.useAt = useAt;
    }

    public void setBbsSj(String bbsSj){
        this.bbsSj = bbsSj;
    }
    public void setBbsCn(String bbsCn){
        this.bbsCn = bbsCn;
    }
}
