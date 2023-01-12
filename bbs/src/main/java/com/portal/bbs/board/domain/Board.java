package com.portal.bbs.board.domain;

import com.portal.bbs.base.domain.BaseEntity;
import lombok.*;
import javax.persistence.*;

import static org.springframework.util.StringUtils.*;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long id;

    @Column(name = "BOARD_NAME")
    private String boardName;

    @Column(name = "LINE_REPLY_YN")
    private String lineReplyYn;

    @Column(name = "REPLY_YN")
    private String useReplyYn;

    @Builder
    public Board(String boardName, String lineReplyYn, String useReplyYn) {
        this.setBoardName(boardName);
        this.setLineReplyYn(lineReplyYn);
        this.setUseReplyYn(useReplyYn);
    }

    public Board(Long id) {
        this.id = id;
    }

    public void changeBoard(Board board) {
        if(hasText(board.getBoardName())){
            this.setBoardName(board.getBoardName());
        }
        if(hasText(board.getLineReplyYn())){
            this.setBoardName(board.getLineReplyYn());
        }
        if(hasText(board.getUseReplyYn())){
            this.setBoardName(board.getUseReplyYn());
        }
    }
}
