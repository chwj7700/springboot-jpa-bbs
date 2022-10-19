package com.portal.bbs.board.repository;

import com.portal.bbs.board.domain.Board;
import com.portal.bbs.board.domain.BoardItem;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BoardItemRepository {

    @PersistenceContext
    private EntityManager em;

//    public Long save(BoardItem boardItem){
//        em.persist(boardItem);
//        return boardItem.getBoard();
//    }

//    public BoardItem findById(Long id){
//        return em.find(BoardItem.class, id);
//    }
}
