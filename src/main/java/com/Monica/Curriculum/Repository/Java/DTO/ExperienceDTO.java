package com.Monica.Curriculum.Repository.Java.DTO;

import java.util.Date;
import java.util.UUID;

public record ExperienceDTO(
        String function,
        String company,
        String time,
        UUID user_id
) {
}
