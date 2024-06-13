package com.Monica.Curriculum.Repository.Java.DTO;

import com.Monica.Curriculum.Repository.Java.model.Education;

import java.util.Date;
import java.util.UUID;

public record ListEducationDTO(
        UUID id,
        String name,
        Date conclusion_ed,
        String institution,
        UUID user_id
) {
    public ListEducationDTO(Education education){

        this( education.getId(), education.getName(), education.getConclusion_ed(), education.getInstitution(), education.getUser().getId());
    }
}