package com.portal.bbs.board.dto;

import com.portal.bbs.base.domain.BaseEntity;
import com.portal.bbs.board.domain.Board;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BoardResultDTO extends BaseEntity {

    private Long id;

    private String boardName;

    private String lineReplyYn;

    private String useReplyYn;

    public BoardResultDTO(Board board){
        this.setId(board.getId());
        this.setBoardName(board.getBoardName());
        this.setLineReplyYn(board.getLineReplyYn());
        this.setUseReplyYn(board.getUseReplyYn());
        this.setCreatedBy(board.getCreatedBy());
        this.setCreatedDate(board.getCreatedDate());
        this.setUpdatedBy(board.getUpdatedBy());
        this.setUpdatedDate(board.getUpdatedDate());
    }
}
