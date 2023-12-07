package com.bajidan.ingrydspringboot.repository;

import com.bajidan.ingrydspringboot.model.JavaStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JavaStudentRepository extends JpaRepository<JavaStudent, Integer> {

    Optional<JavaStudent> findByEmail(String email);

}
