package com.umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class MissionRequest {
    @NotBlank(message = "미션 내용을 입력해주세요.")
    private String title;

    @NotNull(message = "미션 마감기한을 입력해주세요.")
    private LocalDate deadline;

    @NotNull(message = "리워드를 입력하세요.")
    private Integer reward;
}
