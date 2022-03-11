package com.mc.restwithh2.service.student;

import com.mc.restwithh2.dto.StudentDto;
import com.mc.restwithh2.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Optional<Student> findById(Long id);

    Optional<List<StudentDto>> getStudents();

    void saveAllStudents(List<StudentDto> studentDtoList);

    void addStudent(StudentDto studentDto);

    void updateStudent(Long studentId, StudentDto studentDto);

    void deleteStudent(Long studentId);
}
