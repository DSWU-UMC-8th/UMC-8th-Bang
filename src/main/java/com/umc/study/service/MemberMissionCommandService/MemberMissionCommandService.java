package com.umc.study.service.MemberMissionCommandService;

import com.umc.study.apiPayload.code.status.ErrorStatus;
import com.umc.study.apiPayload.exception.CustomException;
import com.umc.study.domain.Member;
import com.umc.study.domain.Mission;
import com.umc.study.domain.mapping.MemberMission;
import com.umc.study.repository.MemberMissionRepository.MemberMissionRepository;
import com.umc.study.repository.MemberRepository.MemberRepository;
import com.umc.study.repository.MissionRepository.MissionRepository;
import com.umc.study.web.dto.MissionChallengeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandService {
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    public void challengeMission(Long missionId, MissionChallengeRequest request) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new CustomException(ErrorStatus.MISSION_NOT_FOUND));

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new CustomException(ErrorStatus.MEMBER_NOT_FOUND));

        MemberMission memberMission = MemberMission.builder()
                .mission(mission)
                .member(member)
                .commitment(request.getCommitment())
                .build();

        memberMissionRepository.save(memberMission);
    }
}
