package com.Monica.Curriculum.Repository.Java.DTO;

import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record AttEducationDTO(
        @NotNull
        UUID id,
        String name,
        Date conclusion_ed,
        String institution,
        UUID user_id
) {
}

