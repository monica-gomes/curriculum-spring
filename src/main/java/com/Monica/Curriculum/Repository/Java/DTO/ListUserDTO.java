package com.Monica.Curriculum.Repository.Java.DTO;

import com.Monica.Curriculum.Repository.Java.model.User;

import java.util.Date;
import java.util.UUID;

public record ListUserDTO(
        UUID id,
        String name,
        Date date,
        int age
) {
    public ListUserDTO(User user){

        this( user.getId(),user.getName(), user.getDate(),user.getAge());
    }
}