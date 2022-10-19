package com.portal.bbs;

import com.portal.bbs.board.domain.Board;
import com.portal.bbs.board.repository.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BoardRepositoryTest {
    
    @Autowired
    BoardRepository boardRepository;
    
    @Test
    public void testBoard() throws Exception{
        //given
        Board board = new Board("공지사항", "Y", "Y");

        //when
        Long savedId = boardRepository.save(board);
        Board findBoard = boardRepository.findByBoardId(savedId);

        //then
        Assertions.assertThat(findBoard.getBoardId()).isEqualTo(board.getBoardId());
        Assertions.assertThat(findBoard.getBoardName()).isEqualTo(board.getBoardName());
        Assertions.assertThat(findBoard).isEqualTo(board);
        System.out.println("findMember == board: " + (findBoard == board));
    }
}
