package com.profiles.clsung.api.board.data.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardUpdateRequestDTO {

    @NotNull(message = "게시판 ID는 필수 값 입니다.")
    @Schema(name = "bbsId", example = "BD0000000001")
    private String bbsId;

    @Schema(name = "bbsSj", description = "게시판 제목")
    private String bbsSj;

    @Schema(name = "bbsCn", description = "게시판 내용")
    private String bbsCn;

    @Schema(name = "useAt", example = "Y", defaultValue = "Y")
    private String useAt;

    @Schema(name = "updusrId", description = "수정자ID")
    private String updusrId;

    @Schema(name = "updtDt", description = "수정일시")
    private LocalDateTime updtDt;

}
