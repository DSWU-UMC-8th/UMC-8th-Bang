package com.umc.study.domain;

import com.umc.study.domain.common.BaseEntity;
import com.umc.study.domain.mapping.MemberAgree;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Terms extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //ddl에서 not null로 쓰여있으므로
    @Column(nullable = false, length = 20)
    private String title;
    // body  /   text / not null 이므로
    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean optional;

    @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL)
    @Builder.Default
    private List<MemberAgree> memberAgreeList = new ArrayList<>();
}