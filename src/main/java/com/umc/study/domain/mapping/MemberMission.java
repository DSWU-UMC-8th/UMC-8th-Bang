package com.umc.study.domain.mapping;

import com.umc.study.domain.Member;
import com.umc.study.domain.Mission;
import com.umc.study.domain.common.BaseEntity;
import com.umc.study.domain.enums.MissionStatus;
import jakarta.persistence.*;
import lombok.*;
// entity
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Collection 'com.umc.study.domain.Member.memberMissionList' is 'mappedBy' a property named 'member' which does not exist in the target entity 'com.umc.study.domain.mapping.MemberMission'로 추가함
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
    // Collection 'com.umc.study.domain.Mission.memberMissionList' is 'mappedBy' a property named 'mission' which does not exist in the target entity 'com.umc.study.domain.mapping.MemberMission'오류로 추가함.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    @Column(nullable = false)
    private String commitment;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;
}
