package com.portal.bbs.boardItem.controller;

import com.portal.bbs.board.domain.Board;
import com.portal.bbs.boardItem.domain.BoardItem;
import com.portal.bbs.boardItem.dto.BoardItemResultDTO;
import com.portal.bbs.boardItem.dto.BoardItemSearchDTO;
import com.portal.bbs.boardItem.service.BoardItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardItemController {

    private final BoardItemService boardItemService;

    @GetMapping(value="board/getAllBoardItems")
    public List<BoardItemResultDTO> getAllBoardItems(){

        return boardItemService.findAll();
    }

    @GetMapping(value="board/getBoardItemByBoard")
    public BoardItemResultDTO getBoardItemById(@RequestBody BoardItemSearchDTO boardItemSearchDTO) {

        return boardItemService.findById(boardItemSearchDTO.getId());
    }

    @GetMapping(value="board/getBoardItemWithPage")
    public Page<BoardItemResultDTO> getBoardItemsByBoardWithPage(@RequestBody BoardItemSearchDTO boardItemSearchDTO) {

        int page = boardItemSearchDTO.getPage();
        int pageSize = boardItemSearchDTO.getPageSize();
        Long boardId = boardItemSearchDTO.getBoardId();
        Board board = new Board(boardId);

        return boardItemService.findBoardItemsByBoardWithPage(board, page, pageSize);
    }

    @PostMapping(value="boardItem/save")
    public void createBoard(@RequestBody BoardItem boardItem){

        boardItemService.save(boardItem);
    }

    @PostMapping(value="boardItem/delete")
    public void deleteBoard(@RequestBody BoardItem boardItem){

        boardItemService.delete(boardItem);
    }
}
