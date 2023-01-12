package com.portal.bbs.boardItem.domain;

import com.portal.bbs.base.domain.BaseEntity;
import com.portal.bbs.board.domain.Board;
import lombok.*;


import javax.persistence.*;

import static javax.persistence.FetchType.*;
import static org.springframework.util.ObjectUtils.*;
import static org.springframework.util.StringUtils.hasText;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class BoardItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="BOARD_ITEM_ID")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENTS")
    private String contents;

    @Column(name = "REPLY_STEP")
    private Integer replyStep;

    @Column(name = "TEMP_YN")
    private String tempYn;

    public void changeBoardItem(BoardItem boardItem) {
        if(!isEmpty(boardItem.getId())){
            this.setId(boardItem.getId());
        }
        if(!isEmpty(boardItem.getBoard())) {
            this.setBoard(boardItem.getBoard());
        }
        if(!hasText(boardItem.getTitle())) {
            this.setTitle(boardItem.getTitle());
        }
        if(!hasText(boardItem.getContents())) {
            this.setContents(boardItem.getContents());
        }
        if(!hasText(boardItem.getTitle())) {
            this.setReplyStep(boardItem.getReplyStep());
        }
        if(!hasText(boardItem.getTempYn())) {
            this.setTempYn(boardItem.getTempYn());
        }
    }
}
