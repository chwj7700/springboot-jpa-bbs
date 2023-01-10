package com.portal.bbs.board.service;

import com.portal.bbs.board.domain.Board;
import com.portal.bbs.board.dto.BoardResultDTO;
import com.portal.bbs.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(Board board) {
        boardRepository.save(board);
    }

    public BoardResultDTO findByBoardId(Long boardId) {
        return boardRepository.findById(boardId)
                .map(board -> new BoardResultDTO(board))
                .orElseThrow();
    }

    public List<BoardResultDTO> findAll() {
        return boardRepository.findAll()
                .stream()
                .map(board -> new BoardResultDTO(board))
                .toList();
    }

    public Page<BoardResultDTO> findPagebyId(Long boardId, int page, int size) {

        Sort sort = Sort.by(Sort.Direction.DESC, "boardId");
        PageRequest pageRequest = PageRequest.of(page, size, sort);

        Page<BoardResultDTO> boards = boardRepository.findPageById(boardId, pageRequest)
                .map((board -> new BoardResultDTO(board)));
        return boards;
    }
}
