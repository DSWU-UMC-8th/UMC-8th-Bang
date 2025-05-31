package com.umc.study.domain.mapping;

import com.umc.study.domain.Terms;
import com.umc.study.domain.common.BaseEntity;
import jakarta.persistence.*;
import com.umc.study.domain.Member;

@Entity
public class MemberAgree extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "terms_id")
    private Terms terms;
}
