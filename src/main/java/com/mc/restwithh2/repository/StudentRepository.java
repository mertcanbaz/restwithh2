package com.mc.restwithh2.repository;

import com.mc.restwithh2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAll();

    Optional<Student> findStudentById(Long id);

    Optional<Student> findStudentByEmail(String email);

}
