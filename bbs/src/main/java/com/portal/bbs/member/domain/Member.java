package com.portal.bbs.member.domain;

import com.portal.bbs.base.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Column(name = "MEMBER_NAME")
    private String memberName;
}
