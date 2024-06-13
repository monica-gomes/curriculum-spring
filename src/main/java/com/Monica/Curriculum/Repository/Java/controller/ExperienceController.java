package com.Monica.Curriculum.Repository.Java.controller;


import com.Monica.Curriculum.Repository.Java.service.ExperienceService;
import com.Monica.Curriculum.Repository.Java.DTO.AttExperienceDTO;
import com.Monica.Curriculum.Repository.Java.DTO.ExperienceDTO;
import com.Monica.Curriculum.Repository.Java.DTO.ListExperienceDTO;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/experience")
@Validated
public class ExperienceController {



    @Autowired
    ExperienceService experienceService;
    @GetMapping()
    public Page<ListExperienceDTO> listarExperiences(Pageable paginacao){
        return experienceService.listarExperience(paginacao);
    }



    @PostMapping
    @Transactional
    public String cadastrarExperience(@RequestBody ExperienceDTO experienceDTO){

        //return "Created";
        return experienceService.cadastrarExperience(experienceDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String deletarExperience(@PathVariable @NotNull UUID id){
        return experienceService.deletarExperience(id);
    }

    @PutMapping
    @Transactional
    public String atualizarExperience(@RequestBody AttExperienceDTO attExperienceDTO){
        return experienceService.atualizarExperience(attExperienceDTO);
    }
}
