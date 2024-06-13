package com.Monica.Curriculum.Repository.Java.DTO;

import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record AttUserDTO(
        @NotNull
        UUID id,
        String name,
        Date date,
        int age
) {
}