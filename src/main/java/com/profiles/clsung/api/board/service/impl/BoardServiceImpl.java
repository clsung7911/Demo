package com.profiles.clsung.api.board.service.impl;

import com.profiles.clsung.api.board.data.entity.Board;
import com.profiles.clsung.api.board.data.request.BoardRequestDTO;
import com.profiles.clsung.api.board.respository.BoardRepository;
import com.profiles.clsung.api.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public List<Board> selectByList() {
        return boardRepository.findAll();
    }

    @Override
    public Optional<Board> selectById(String bbsId) {
        return boardRepository.findById(bbsId);
    }
}
