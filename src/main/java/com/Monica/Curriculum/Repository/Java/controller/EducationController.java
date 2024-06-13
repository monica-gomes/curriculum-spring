package com.Monica.Curriculum.Repository.Java.controller;


import com.Monica.Curriculum.Repository.Java.DTO.AttEducationDTO;
import com.Monica.Curriculum.Repository.Java.DTO.EducationDTO;
import com.Monica.Curriculum.Repository.Java.DTO.ListEducationDTO;
import com.Monica.Curriculum.Repository.Java.service.EducationService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/education")
@Validated
public class EducationController {



    @Autowired
    EducationService educationService;
    @GetMapping()
    public Page<ListEducationDTO> listarEducation(Pageable paginacao){
        return educationService.listarEducation(paginacao);
    }



    @PostMapping
    @Transactional
    public String cadastrarEducation(@RequestBody EducationDTO educationDTO){

        //return "Created";
        return educationService.cadastrarEducation(educationDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String deletarEducation(@PathVariable @NotNull UUID id){
        return educationService.deletarEducation(id);
    }

    @PutMapping
    @Transactional
    public String atualizarEducation(@RequestBody AttEducationDTO attEducationDTO){
        return educationService.atualizarEducation(attEducationDTO);
    }
}
