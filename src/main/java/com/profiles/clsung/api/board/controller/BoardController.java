package com.profiles.clsung.api.board.controller;

import com.profiles.clsung.api.board.data.entity.Board;
import com.profiles.clsung.api.board.data.request.BoardRequestDTO;
import com.profiles.clsung.api.board.data.request.BoardUpdateRequestDTO;
import com.profiles.clsung.api.board.service.BoardService;
import com.profiles.clsung.cmm.base.BaseController;
import com.profiles.clsung.cmm.response.ApiResponse;
import com.profiles.clsung.cmm.response.ResponseWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Board", description = "게시판 API를 사용하기 위한 예제입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/board")
public class BoardController extends BaseController {

    private final BoardService boardService;

    @Operation(summary = "게시판 목록 조회", description = "게시판 목록을 조회한다.")
    @GetMapping("/boards")
    public ApiResponse<List<Board>> selectByList(){
        return ResponseWrapper.success(boardService.selectByList());
    }

    @Operation(summary = "게시판 상세 조회", description = "게시판 상세 정보를 조회한다.")
    @GetMapping("/board/{bbsId}")
    public ApiResponse<Board> selectById(@PathVariable(value = "bbsId") String bbsId){
        Board board = boardService.selectById(bbsId);
        return ResponseWrapper.success(board);
    }

    @Operation(summary = "게시판 등록", description = "게시판에 내용을 저장한다.")
    @PostMapping("/board")
    public ApiResponse<Board> insertBoard(@Valid @RequestBody BoardRequestDTO requestDTO){
        return ResponseWrapper.success(boardService.insertBoard(requestDTO));
    }

    @Operation(summary = "게시판 수정", description = "게시판의 내용을 수정한다.")
    @PutMapping("/board")
    public ApiResponse<Void> updateBoard(@Valid @RequestBody BoardUpdateRequestDTO requestDTO){
        boardService.updateBoard(requestDTO);
        return ResponseWrapper.success();
    }

    @Operation(summary = "게시판 삭제", description = "게시판의 내용을 삭제한다.")
    @DeleteMapping("/board/{bbsId}")
    public ApiResponse<Void> deleteBoard(@PathVariable(value = "bbsId") String bbsId){
        boardService.deleteBoard(bbsId);
        return ResponseWrapper.success();
    }
}
