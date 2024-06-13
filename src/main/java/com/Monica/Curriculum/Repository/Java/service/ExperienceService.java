package com.Monica.Curriculum.Repository.Java.service;

import com.Monica.Curriculum.Repository.Java.repository.ExperienceRepository;
import com.Monica.Curriculum.Repository.Java.repository.UserRepository;
import com.Monica.Curriculum.Repository.Java.DTO.ExperienceDTO;
import com.Monica.Curriculum.Repository.Java.DTO.AttExperienceDTO;
import com.Monica.Curriculum.Repository.Java.DTO.ListExperienceDTO;
import com.Monica.Curriculum.Repository.Java.model.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExperienceService {

    @Autowired
    ExperienceRepository experienceRepository;
    @Autowired
    UserRepository userRepository;

    public String cadastrarExperience(ExperienceDTO experienceDTO){
        Experience experience = new Experience();
        experience.setCompany(experienceDTO.company());
        experience.setTime(experienceDTO.time());
        experience.setFunction(experienceDTO.function());
        experience.setUser(userRepository.getReferenceById(experienceDTO.user_id()));
        experienceRepository.save(experience);
        return "Created";
    }

    public String deletarExperience(UUID id){
        experienceRepository.deleteById(id);;
        return "Deleted";
    }

    public String atualizarExperience(AttExperienceDTO attExperienceDTO){
        Experience experience = experienceRepository.getReferenceById(attExperienceDTO.id());
        if(attExperienceDTO.company()!=null) experience.setCompany(attExperienceDTO.company());
        if(attExperienceDTO.time()!=null) experience.setTime(attExperienceDTO.time());
        if(attExperienceDTO.function()!=null) experience.setFunction(attExperienceDTO.function());

        return "Atualizado";
    }
    public Page<ListExperienceDTO> listarExperience(Pageable paginacao){
        return experienceRepository.findAll(paginacao).map(ListExperienceDTO::new);

    }
}