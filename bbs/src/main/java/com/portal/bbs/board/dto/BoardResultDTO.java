package com.portal.bbs.board.dto;

import com.portal.bbs.board.domain.Board;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class BoardResultDTO {

    private Long id;

    private String boardName;

    private String lineReplyYn;

    private String useReplyYn;

    public BoardResultDTO(Board board){
        this.id = board.getId();
        this.boardName = board.getBoardName();
        this.lineReplyYn = board.getLineReplyYn();
        this.useReplyYn = board.getUseReplyYn();
    }
}
