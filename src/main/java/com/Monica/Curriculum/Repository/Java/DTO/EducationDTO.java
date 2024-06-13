package com.Monica.Curriculum.Repository.Java.DTO;

import java.util.Date;
import java.util.UUID;

public record EducationDTO(
        String name,
        Date conclusion_ed,
        String institution,
        UUID user_id
) {
}
