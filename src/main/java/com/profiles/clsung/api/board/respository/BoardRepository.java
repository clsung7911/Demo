package com.profiles.clsung.api.board.respository;

import com.profiles.clsung.api.board.data.entity.Board;
import com.profiles.clsung.api.board.data.response.BoardResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, String> {
    List<Board> findAll();

    Optional<Board> findById(String bbsId);
}
