package com.umc.study.apiPayload.exception;

import com.umc.study.apiPayload.code.status.ErrorStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private final ErrorStatus errorStatus;
}
