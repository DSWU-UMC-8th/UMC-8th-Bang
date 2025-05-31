package com.umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class StoreRequestDTO {
    @Getter
    public static class Create {
        @NotBlank
        private String name;

        @NotBlank
        private String address;

        @Size(max = 255)
        private String description;
    }
}
