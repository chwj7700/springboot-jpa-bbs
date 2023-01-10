package com.portal.bbs.board.dto;

import com.portal.bbs.base.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Data
public class BoardSearchDTO extends BaseEntity {

    private Long id;

    private String boardName;
}
