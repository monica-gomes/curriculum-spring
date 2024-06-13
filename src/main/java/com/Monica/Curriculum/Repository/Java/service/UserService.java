package com.Monica.Curriculum.Repository.Java.service;

import com.Monica.Curriculum.Repository.Java.DTO.AttUserDTO;
import com.Monica.Curriculum.Repository.Java.DTO.ListUserDTO;
import com.Monica.Curriculum.Repository.Java.DTO.UserDTO;
import com.Monica.Curriculum.Repository.Java.model.User;
import com.Monica.Curriculum.Repository.Java.repository.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String cadastrarUser(UserDTO userDTO){
        User user = new User(userDTO);
        userRepository.save(user);
        return "Created";
    }

    public String deletarUser(UUID id){
        userRepository.deleteById(id);;
        return "Deleted";
    }

    public String atualizarUser(AttUserDTO attUserDTO){
        User user = userRepository.getReferenceById(attUserDTO.id());
        if(attUserDTO.name()!=null) user.setName(attUserDTO.name());
        if(attUserDTO.date()!=null) user.setDate(attUserDTO.date());
        if(attUserDTO.age()!=0) user.setAge(attUserDTO.age());

        return "Atualizado";
    }
    public Page<ListUserDTO> listarUser(Pageable paginacao){
        return userRepository.findAll(paginacao).map(ListUserDTO::new);

    }
}