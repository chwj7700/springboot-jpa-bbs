package com.portal.bbs.board.service;

import com.portal.bbs.board.domain.Board;
import com.portal.bbs.board.dto.BoardResultDTO;
import com.portal.bbs.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardResultDTO findByBoardId(Long boardId) {
        return boardRepository.findById(boardId)
                .map(BoardResultDTO::new)
                .orElseThrow();
    }

    public List<BoardResultDTO> findAll() {
        return boardRepository.findAll()
                .stream()
                .map(BoardResultDTO::new)
                .toList();
    }

    public Page<BoardResultDTO> findAllWithPage(int page, int size) {

        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        PageRequest pageRequest = PageRequest.of(page, size, sort);

        return boardRepository.findAll(pageRequest).map((BoardResultDTO::new));
    }

    @Transactional
    public void save(Board board) {

        /*Optional<Board> boardOptional = boardRepository.findById(board.getId());

        if(boardOptional.isEmpty()) {*/
            boardRepository.save(board);
        /*}else{
            Board boardOrigin = boardOptional.get();
            boardOrigin.changeBoard(board);
            boardRepository.save(boardOrigin);
        }*/
    }

    @Transactional
    public void delete(Board board){
        boardRepository.delete(board);
    }
}
