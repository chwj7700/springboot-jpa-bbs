package com.portal.bbs.board.service;

import com.portal.bbs.board.domain.Board;
import com.portal.bbs.board.dto.BoardResultDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class BoardServiceTest {

    @Autowired
    BoardService boardService;

    @Test
    void findAll() {

        //given
        List<Board> boards = new ArrayList<>();
        boards.add(new Board("공지사항", "Y", "Y"));
        boards.add(new Board("인사", "Y", "Y"));

        //when
        //boardService.save(board);
        List<BoardResultDTO> findBoards = boardService.findAll();

        //then
        Assertions.assertThat(boards.size() == findBoards.size());
        System.out.println("boardsSize = " + boards.size());
    }

    @Test
    void findByBoardId() {

        //given
        List<Board> boards = new ArrayList<>();
        boards.add(new Board("공지사항", "Y", "Y"));
        boards.add(new Board("인사", "Y", "Y"));

        //when
        for(Board board : boards){
            boardService.save(board);
            Long id = board.getId();
            BoardResultDTO findBoard = boardService.findByBoardId(id);

            //then
            Assertions.assertThat(findBoard.getId().equals(board.getId()));
            System.out.println("id = " + findBoard.getId());
        }
    }

    @Test
    void findAllWithPage() {

        //given
        List<Board> boards = new ArrayList<>();
        boards.add(new Board("공지사항", "Y", "Y"));
        boards.add(new Board("인사", "Y", "Y"));

        //when
        for(Board board : boards) {
            boardService.save(board);
        }
        int page = 0;
        int pageSize = 10;
        Page<BoardResultDTO> findBoards = boardService.findAllWithPage(page, pageSize);

        //then
        Assertions.assertThat(boards.size() == findBoards.getSize());
        System.out.println("boardsSize = " + boards.size());
    }

    @Test
    void save() {

        //given
        Board board = new Board("공지사항", "Y", "Y");

        //when
        boardService.save(board);
        Long id = board.getId();
        BoardResultDTO findBoard = boardService.findByBoardId(id);

        //then
        Assertions.assertThat(findBoard.getId().equals(board.getId()));
        System.out.println("id = " + findBoard.getId());
    }

    @Test
    void delete() throws Exception {

        //given
        Board board = new Board("공지사항", "Y", "Y");
        boardService.save(board);

        Long id = board.getId();
        BoardResultDTO findBoard = boardService.findByBoardId(id);

        Assertions.assertThat(findBoard.getId().equals(board.getId()));
        System.out.println("id = " + findBoard.getId());

        //when
        boardService.delete(board);
        try {
            boardService.findByBoardId(id);
        }catch (NoSuchElementException e){
            System.out.println("데이터가 정상적으로 삭제되었습니다.");
            return;
        }

        //then
        System.out.println("데이터가 정상적으로 삭제되지 않았습니다.");
        throw new Exception();

    }
}