package com.portal.bbs.boardItem.dto;

import com.portal.bbs.base.domain.BaseEntity;
import com.portal.bbs.board.domain.Board;
import com.portal.bbs.boardItem.domain.BoardItem;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BoardItemResultDTO extends BaseEntity {

    private Long id;

    private String title;

    private String contents;

    private Board board;

    private String tempYn;

    private Integer replyStep;

    public BoardItemResultDTO( BoardItem boardItem){
        this.setId(boardItem.getId());
        this.setTitle(boardItem.getTitle());
        this.setContents(boardItem.getContents());
        this.setBoard(boardItem.getBoard());
        this.setTempYn(boardItem.getTempYn());
        this.setReplyStep(boardItem.getReplyStep());
        this.setCreatedBy(boardItem.getCreatedBy());
        this.setCreatedDate(boardItem.getCreatedDate());
        this.setUpdatedBy(boardItem.getUpdatedBy());
        this.setUpdatedDate(boardItem.getUpdatedDate());
    }
}
