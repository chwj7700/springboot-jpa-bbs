package com.portal.bbs.board.dto;

import com.portal.bbs.base.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
public class BoardSearchDTO extends BaseEntity {

    private Long boardId;

    private String boardName;
}
