package com.Monica.Curriculum.Repository.Java.model;

import com.Monica.Curriculum.Repository.Java.DTO.EducationDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "educationn")//nome da tabela
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private Date conclusion_ed;
    private String institution;


    @ManyToOne
    private User user;

    public Education(EducationDTO educationDTO){
        this.name = educationDTO.name();
        this.conclusion_ed = educationDTO.conclusion_ed();
        this.institution = educationDTO.institution();

    }

}
