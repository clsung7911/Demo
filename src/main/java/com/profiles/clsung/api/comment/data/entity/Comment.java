package com.profiles.clsung.api.comment.data.entity;

import com.profiles.clsung.cmm.base.BaseSystemFieldEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "comment")
public class Comment extends BaseSystemFieldEntity {
    @Id
    @Column(name = "cmnt_id")
    private String cmntId;
    @Column(name = "bbs_id")
    private String bbsId;
    @Column(name = "cmnt_cn")
    private String cmntCn;

    @Builder
    public Comment(String cmntId, String bbsId, String cmntCn) {
        this.cmntId = cmntId;
        this.bbsId = bbsId;
        this.cmntCn = cmntCn;
    }

    public void setCmntCn(String cmntCn) {
        this.cmntCn = cmntCn;
    }
}