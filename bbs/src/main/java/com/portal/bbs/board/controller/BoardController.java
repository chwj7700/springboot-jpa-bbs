package com.portal.bbs.board.controller;

import com.portal.bbs.board.domain.Board;
import com.portal.bbs.board.dto.BoardResultDTO;
import com.portal.bbs.board.dto.BoardSearchDTO;
import com.portal.bbs.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping(value="board/getAllBoards")
    public List<BoardResultDTO> getAllBoards(){

        return boardService.findAll();
    }

    @GetMapping(value="board/getBoardById")
    public BoardResultDTO getBoardById(@RequestBody BoardSearchDTO boardSearchDTO) {

        Long id = boardSearchDTO.getId();

        return boardService.findByBoardId(id);
    }

    @GetMapping(value="board/getBoardByIdWithPage")
    public Page<BoardResultDTO> getBoardsWithPage(@RequestBody BoardSearchDTO boardSearchDTO) {

        int page = boardSearchDTO.getPage();
        int pageSize = boardSearchDTO.getPageSize();
        Long id = boardSearchDTO.getId();

        return boardService.findBoardsByIdWithPage(id, page, pageSize);
    }

    @PostMapping(value="board/save")
    public void createBoard(@RequestBody Board board){

        boardService.save(board);
    }

    @PostMapping(value="board/delete")
    public void deleteBoard(@RequestBody Board board){

        boardService.delete(board);
    }
}
