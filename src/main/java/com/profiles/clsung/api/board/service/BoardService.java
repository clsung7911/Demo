package com.profiles.clsung.api.board.service;

import com.profiles.clsung.api.board.data.entity.Board;
import com.profiles.clsung.api.board.data.request.BoardRequestDTO;
import com.profiles.clsung.api.board.data.request.BoardUpdateRequestDTO;

import java.util.List;

public interface BoardService {
    List<Board> selectByList();

    Board selectById(String bbsId);

    Board insertBoard(BoardRequestDTO requestDTO);

    void updateBoard(BoardUpdateRequestDTO requestDTO);

    void deleteBoard(String bbsId);
}
