package com.portal.bbs.board.repository;

import com.portal.bbs.board.domain.BoardItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardItemRepository extends JpaRepository<BoardItem, Long> {
    Page<BoardItem> findPageById (long id, Pageable pageable);
}
