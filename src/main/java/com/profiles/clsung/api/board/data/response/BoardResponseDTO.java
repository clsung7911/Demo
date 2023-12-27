package com.profiles.clsung.api.board.data.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Schema
public class BoardResponseDTO {
    @Schema(name = "게시판ID")
    private String bbsId;
    @Schema(name = "게시판 내용")
    private String bbsCn;
    @Schema(name = "사용여부")
    private String useAt;
    @Schema(name = "등록자ID")
    private String registerId;
    @Schema(name = "등록일시")
    private String registDt;
    @Schema(name = "수정자ID")
    private String updusrId;
    @Schema(name = "수정일시")
    private String updtDt;

    @Builder
    public BoardResponseDTO(String bbsId, String bbsCn, String useAt,
                            String registerId, String registDt, String updusrId, String updtDt) {
        this.bbsId = bbsId;
        this.bbsCn = bbsCn;
        this.useAt = useAt;
        this.registerId = registerId;
        this.registDt = registDt;
        this.updusrId = updusrId;
        this.updtDt = updtDt;
    }
}
