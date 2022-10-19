package com.portal.bbs.board.repository;

import com.portal.bbs.board.domain.Board;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Board board){
        em.persist(board);
        return board.getBoardId();
    }

    public Board findByBoardId(Long id){
        return em.find(Board.class, id);
    }

    public List<Board> findAllBoards() {
        List<Board> boards = em.createQuery("select Board from Board", Board.class).getResultList();
        return boards;
    }
}
