package com.portal.bbs.board.dto;

import com.portal.bbs.base.domain.BaseEntity;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public class BoardSearchDTO extends BaseEntity {

    private Long id;

    private String boardName;

    private int page;

    private int pageSize;
}
