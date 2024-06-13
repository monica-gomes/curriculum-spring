package com.Monica.Curriculum.Repository.Java.model;

import com.Monica.Curriculum.Repository.Java.DTO.ExperienceDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "experiences")//nome da tabela
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String company;
    private String time;
    private String function;

    @ManyToOne
    private User user;

    public Experience(ExperienceDTO experienceDTO){
        this.company = experienceDTO.company();
        this.time = experienceDTO.time();
        this.function = experienceDTO.function();

    }

}
