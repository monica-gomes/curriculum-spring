package com.Monica.Curriculum.Repository.Java.model;

import com.Monica.Curriculum.Repository.Java.DTO.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private Date date;

    private int age;

   /* @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Education> education;*/

    public User(UserDTO userDTO){
        this.name = userDTO.name();
        this.date = userDTO.date();
        this.age = userDTO.age();

    }

}