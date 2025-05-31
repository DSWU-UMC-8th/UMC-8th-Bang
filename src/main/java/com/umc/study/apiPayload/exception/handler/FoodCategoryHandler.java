package com.umc.study.apiPayload.exception.handler;

import com.umc.study.apiPayload.code.status.ErrorStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FoodCategoryHandler extends RuntimeException {
    private final ErrorStatus errorStatus;
}