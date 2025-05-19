package com.umc.study.web.dto;

import com.umc.study.custom.CommitmentLength;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MissionChallengeRequest {

    @NotNull(message = "회원 ID는 필수입니다.")
    private Long memberId;

    @NotBlank(message = "한 줄 각오를 입력해주세요.")
    @CommitmentLength // 커스텀 어노테이션 (예: 최소 5자 이상)
    private String commitment;
}
