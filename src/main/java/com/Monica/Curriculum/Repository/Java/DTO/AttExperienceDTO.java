package com.Monica.Curriculum.Repository.Java.DTO;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AttExperienceDTO(
        @NotNull
        UUID id,
        String company,
        String time,
        String function,
        UUID user_id
) {
}

