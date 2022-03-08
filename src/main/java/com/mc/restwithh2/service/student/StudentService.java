package com.mc.restwithh2.service.student;

import com.mc.restwithh2.entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Optional<Student> findById(Long id);

    List<Student> getStudents();

    void saveAllStudents(List<Student> studentList);

    void addStudent(Student student);

    void updateStudent(Long studentId, Student student);

    void deleteStudent(Long studentId);
}
