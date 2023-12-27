package com.profiles.clsung.api.board.service;

import com.profiles.clsung.api.board.data.entity.Board;
import com.profiles.clsung.api.board.data.request.BoardRequestDTO;

import java.util.List;
import java.util.Optional;

public interface BoardService {
    List<Board> selectByList();

    Optional<Board> selectById(String bbsId);
}
