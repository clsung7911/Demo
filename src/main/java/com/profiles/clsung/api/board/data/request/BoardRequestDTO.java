package com.profiles.clsung.api.board.data.request;

import com.profiles.clsung.api.board.data.entity.Board;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardRequestDTO {
    @NotNull(message = "게시판 ID는 필수 값 입니다.")
    @Schema(name = "bbsId", example = "BD0000000001")
    private String bbsId;

    @Schema(name = "bbsSj", example = "게시판 제목")
    private String bbsSj;

    @Schema(name = "bbsCn", example = "게시판 내용")
    private String bbsCn;
    
    @Schema(name = "useAt", example = "Y", defaultValue = "Y")
    private String useAt;

    @Schema(name = "registerId", example = "등록자ID")
    private String registerId;

    public Board toBoard(){
        Board board = Board.builder()
                .bbsId(bbsId)
                .bbsSj(bbsSj)
                .bbsCn(bbsCn)
                .useAt(useAt)
                .registerId(registerId)
                .registDt(LocalDateTime.now())
                .build();
        return board;
    }

}
