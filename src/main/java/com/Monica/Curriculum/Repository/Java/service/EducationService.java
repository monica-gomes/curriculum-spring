package com.Monica.Curriculum.Repository.Java.service;

import com.Monica.Curriculum.Repository.Java.DTO.AttEducationDTO;
import com.Monica.Curriculum.Repository.Java.DTO.EducationDTO;
import com.Monica.Curriculum.Repository.Java.DTO.ListEducationDTO;
import com.Monica.Curriculum.Repository.Java.repository.EducationRepository;
import com.Monica.Curriculum.Repository.Java.repository.UserRepository;
import com.Monica.Curriculum.Repository.Java.model.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EducationService {

    @Autowired
    EducationRepository educationRepository;
    @Autowired
    UserRepository userRepository;

    public String cadastrarEducation(EducationDTO educationDTO){
        Education education = new Education();
        education.setInstitution(educationDTO.institution());
        education.setConclusion_ed(educationDTO.conclusion_ed());
        education.setName(educationDTO.name());
        education.setUser(userRepository.getReferenceById(educationDTO.user_id()));
        educationRepository.save(education);
        return "Created";
    }

    public String deletarEducation(UUID id){
        educationRepository.deleteById(id);;
        return "Deleted";
    }

    public String atualizarEducation(AttEducationDTO attEducationDTO){
        Education education = educationRepository.getReferenceById(attEducationDTO.id());
        if(attEducationDTO.name()!=null) education.setName(attEducationDTO.name());
        if(attEducationDTO.conclusion_ed()!=null) education.setConclusion_ed(attEducationDTO.conclusion_ed());
        if(attEducationDTO.institution()!=null) education.setInstitution(attEducationDTO.institution());

        return "Atualizado";
    }
    public Page<ListEducationDTO> listarEducation(Pageable paginacao){
        return educationRepository.findAll(paginacao).map(ListEducationDTO::new);

    }
}