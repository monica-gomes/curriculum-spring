package com.Monica.Curriculum.Repository.Java.DTO;

import com.Monica.Curriculum.Repository.Java.model.Experience;

import java.util.UUID;

public record ListExperienceDTO(
        UUID id,
        String function,
        String company,
        String time,
        UUID user_id

) {
    public ListExperienceDTO(Experience experience){

        this( experience.getId(),experience.getFunction(), experience.getCompany(),experience.getTime(),experience.getUser().getId());
    }
}