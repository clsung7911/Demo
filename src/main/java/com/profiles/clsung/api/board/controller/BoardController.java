package com.profiles.clsung.api.board.controller;

import com.profiles.clsung.api.board.data.entity.Board;
import com.profiles.clsung.api.board.service.BoardService;
import com.profiles.clsung.cmm.base.BaseController;
import com.profiles.clsung.cmm.error.code.CommonErrorCode;
import com.profiles.clsung.cmm.error.exception.RestApiException;
import com.profiles.clsung.cmm.response.ApiResponse;
import com.profiles.clsung.cmm.response.ResponseWrapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class BoardController extends BaseController {

    private final BoardService boardService;

    @Operation(summary = "헬로우 월드 API 조회", description = "헬로우 월드가 swagger에 나타난다", tags = {"sample Controller"})
    @GetMapping("/hello")
    public String helloWorld(){
        return "hello World?";
    }

    @Operation(summary = "게시판 목록 조회", description = "게시판 목록을 조회한다.", tags = {"Board Controller"})
    @GetMapping("/boards")
    public ResponseEntity<List<Board>> selectByList(){
        return ResponseEntity.ok(boardService.selectByList());
    }

    @Operation(summary = "게시판 상세 조회", description = "게시판 상세 정보를 조회한다.", tags = {"Board Controller"})
    @GetMapping("/boards/{bbsId}")
    public ApiResponse<Board> selectById(@PathVariable(value = "bbsId") String bbsId){
        Board board = boardService.selectById(bbsId);
        return ResponseWrapper.success(board);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Board> getUser() {
        throw new RestApiException(CommonErrorCode.INTERNAL_SERVER_ERROR);
    }
}
