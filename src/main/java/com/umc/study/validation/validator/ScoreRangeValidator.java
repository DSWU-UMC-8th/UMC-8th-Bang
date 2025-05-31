package com.umc.study.validation.validator;

import com.umc.study.custom.ScoreRange;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ScoreRangeValidator implements ConstraintValidator<ScoreRange, Float> {

    @Override
    public boolean isValid(Float value, ConstraintValidatorContext context) {
        return value != null && value >= 0.0f && value <= 5.0f;
    }
}

