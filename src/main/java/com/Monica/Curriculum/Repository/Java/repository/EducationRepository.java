package com.Monica.Curriculum.Repository.Java.repository;

import com.Monica.Curriculum.Repository.Java.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EducationRepository extends JpaRepository<Education, UUID> {
}
