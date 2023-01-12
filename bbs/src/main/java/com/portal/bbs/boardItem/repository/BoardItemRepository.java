package com.portal.bbs.boardItem.repository;

import com.portal.bbs.board.domain.Board;
import com.portal.bbs.boardItem.domain.BoardItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardItemRepository extends JpaRepository<BoardItem, Long> {
    Page<BoardItem> findPageByBoard (Board board, Pageable pageable);
}
