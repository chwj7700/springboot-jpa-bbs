package com.portal.bbs.board.domain;

import com.portal.bbs.base.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long boardId;

    @Column(name = "BOARD_NAME")
    private String boardName;

    @Column(name = "LINE_REPLY_YN")
    private String lineReplyYn;

    @Column(name = "REPLY_YN")
    private String useReplyYn;

    @Builder
    public Board(String boardName, String lineReplyYn, String useReplyYn) {
        this.boardName = boardName;
        this.lineReplyYn = lineReplyYn;
        this.useReplyYn = useReplyYn;
    }
}
