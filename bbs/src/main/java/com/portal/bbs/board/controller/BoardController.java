package com.portal.bbs.board.controller;

import com.portal.bbs.board.domain.Board;
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
    @ResponseBody
    public List<Board> getAllBoards(){

        return boardService.findAllBoards();
    }

    @GetMapping(value="board/getBoardById")
    @ResponseBody
    public Board getBoardById(@RequestBody BoardSearchDTO boardSearchDTO) {

        Long id = boardSearchDTO.getBoardId();

        return boardService.findByBoardId(id);
    }
}
