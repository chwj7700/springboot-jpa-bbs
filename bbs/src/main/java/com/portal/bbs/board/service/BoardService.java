package com.portal.bbs.board.service;

import com.portal.bbs.board.domain.Board;
import com.portal.bbs.board.repository.BoardRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Long save(Board board) {
        return boardRepository.save(board);
    }

    public Board findByBoardId(Long boardId) {
        return boardRepository.findByBoardId(boardId);
    }

    public List<Board> findAllBoards() {
        return boardRepository.findAllBoards();
    }
}
