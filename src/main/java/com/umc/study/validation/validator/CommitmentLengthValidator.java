package com.umc.study.validation.validator;

import com.umc.study.custom.CommitmentLength;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CommitmentLengthValidator implements ConstraintValidator<CommitmentLength, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.trim().length() >= 5;
    }
}

