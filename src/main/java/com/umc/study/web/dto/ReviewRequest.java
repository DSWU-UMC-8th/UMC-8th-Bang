package com.umc.study.web.dto;

import com.umc.study.custom.ScoreRange;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewRequest {

    @NotBlank(message = "리뷰 내용을 입력해주세요.")
    private String title;

    @NotNull(message = "리뷰 점수를 입력해주세요.")
    @ScoreRange
    private Float score;

    @NotNull(message = "작성자 ID는 필수입니다.")
    private Long memberId;
}

