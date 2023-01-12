package com.portal.bbs.boardItem.dto;

import com.portal.bbs.base.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BoardItemSearchDTO extends BaseEntity {

    private Long id;

    private Long boardId;

    private String title;

    private String contents;

    private String tempYn;

    private Integer replyStep;

    private int page;

    private int pageSize;
}
