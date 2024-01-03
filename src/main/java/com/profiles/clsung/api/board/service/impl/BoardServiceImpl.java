package com.profiles.clsung.api.board.service.impl;

import com.profiles.clsung.api.board.data.entity.Board;
import com.profiles.clsung.api.board.data.request.BoardRequestDTO;
import com.profiles.clsung.api.board.data.request.BoardUpdateRequestDTO;
import com.profiles.clsung.api.board.respository.BoardRepository;
import com.profiles.clsung.api.board.service.BoardService;
import com.profiles.clsung.cmm.error.code.CommonErrorCode;
import com.profiles.clsung.cmm.error.exception.RestApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Board selectById(String bbsId) {
        return boardRepository.findById(bbsId).orElseThrow(
                () -> new RestApiException(CommonErrorCode.INVALID_PARAMETER)
        );
    }

    @Transactional
    @Override
    public Board insertBoard(BoardRequestDTO requestDTO) throws RestApiException {

        Board board = requestDTO.toBoard();
        board.setRegisterId(requestDTO.getRegisterId());
        Board saveBoard = boardRepository.save(board);
        return saveBoard;
    }

    @Transactional
    @Override
    public void updateBoard(BoardUpdateRequestDTO requestDTO){
        Board board = boardRepository.findById(requestDTO.getBbsId())
                .orElseThrow(() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
        board.setUpdusrId(requestDTO.getUpdusrId());
        board.setBbsSj(requestDTO.getBbsSj());
        board.setBbsCn(requestDTO.getBbsCn());
    }

    @Transactional
    @Override
    public void deleteBoard(String bbsId) throws RestApiException {
        boardRepository.deleteById(bbsId);
    }
}
