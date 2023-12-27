package com.profiles.clsung.api.board.controller;

import com.profiles.clsung.api.board.data.entity.Board;
import com.profiles.clsung.api.board.service.BoardService;
import com.profiles.clsung.cmm.base.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;


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
    public List<Board> selectByList(){
        RestClient restClient = RestClient.create();
        return boardService.selectByList();
    }

    @Operation(summary = "게시판 상세 조회", description = "게시판 상세 정보를 조회한다.", tags = {"Board Controller"})
    @GetMapping("/boards/{bbsId}")
    public Optional<Board> selectById(@PathVariable(value = "bbsId") String bbsId){
        return boardService.selectById(bbsId);
    }

}
