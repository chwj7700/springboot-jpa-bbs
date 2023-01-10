package com.portal.bbs.board.controller;

import com.portal.bbs.board.dto.BoardResultDTO;
import com.portal.bbs.board.dto.BoardSearchDTO;
import com.portal.bbs.board.service.BoardService;
import lombok.RequiredArgsConstructor;
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

        Long id = boardSearchDTO.getBoardId();

        return boardService.findByBoardId(id);
    }
}
