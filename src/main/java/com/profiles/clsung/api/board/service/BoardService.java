package com.profiles.clsung.api.board.service;

import com.profiles.clsung.api.board.data.entity.Board;

import java.util.List;

public interface BoardService {
    List<Board> selectByList();

    Board selectById(String bbsId);
}
