package com.portal.bbs.board.domain;

import com.portal.bbs.base.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="BOARD_ITEM_ID")
    private Long boardItemId;

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
}
