package com.Monica.Curriculum.Repository.Java.controller;


import com.Monica.Curriculum.Repository.Java.DTO.AttUserDTO;
import com.Monica.Curriculum.Repository.Java.DTO.ListUserDTO;
import com.Monica.Curriculum.Repository.Java.DTO.UserDTO;
import com.Monica.Curriculum.Repository.Java.service.UserService;


import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {



    @Autowired
    UserService userService;
    @GetMapping()
    public Page<ListUserDTO> listarUsers(Pageable paginacao){
        return userService.listarUser(paginacao);
    }



    @PostMapping
    @Transactional
    public String cadastrarUser(@RequestBody UserDTO userDTO){

        //return "Created";
        return userService.cadastrarUser(userDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String deletarUser(@PathVariable @NotNull UUID id){
        return userService.deletarUser(id);
    }

    @PutMapping
    @Transactional
    public String atualizarUser(@RequestBody AttUserDTO attUserDTO){
        return userService.atualizarUser(attUserDTO);
    }
}
