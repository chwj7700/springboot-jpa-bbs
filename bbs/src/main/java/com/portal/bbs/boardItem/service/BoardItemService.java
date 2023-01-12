package com.portal.bbs.boardItem.service;

import com.portal.bbs.board.domain.Board;
import com.portal.bbs.boardItem.domain.BoardItem;
import com.portal.bbs.boardItem.dto.BoardItemResultDTO;
import com.portal.bbs.boardItem.repository.BoardItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardItemService {

    private final BoardItemRepository boardItemRepository;

    public BoardItemResultDTO findById(Long boardItemId) {
        return boardItemRepository.findById(boardItemId)
                .map(BoardItemResultDTO::new)
                .orElseThrow();
    }

    public List<BoardItemResultDTO> findAll() {
        return boardItemRepository.findAll()
                .stream()
                .map(BoardItemResultDTO::new)
                .toList();
    }

    public Page<BoardItemResultDTO> findBoardItemsByBoardWithPage(Board board, int page, int size) {

        Sort sort = Sort.by(Sort.Direction.DESC, "board");
        PageRequest pageRequest = PageRequest.of(page, size, sort);

        return boardItemRepository.findPageByBoard(board, pageRequest)
                .map((BoardItemResultDTO::new));
    }

    @Transactional
    public void save(BoardItem boardItem) {

        Optional<BoardItem> boardItemOptional = boardItemRepository.findById(boardItem.getId());

        if(boardItemOptional.isEmpty()) {
            boardItemRepository.save(boardItem);
        }else{
            BoardItem boardItemOrigin = boardItemOptional.get();
            boardItemOrigin.changeBoardItem(boardItem);
            boardItemRepository.save(boardItemOrigin);
        }
    }

    @Transactional
    public void delete(BoardItem boardItem){
        boardItemRepository.delete(boardItem);
    }
}
