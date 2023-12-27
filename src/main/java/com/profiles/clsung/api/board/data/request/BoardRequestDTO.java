package com.profiles.clsung.api.board.data.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BoardRequestDTO {
    @NotNull(message = "게시판 ID는 필수 값 입니다.")
    @Schema(name = "bbsId", example = "BD00000000001")
    private String bbsId;
}
