package com.mc.restwithh2.controller.student;

import com.mc.restwithh2.dto.StudentDto;
import com.mc.restwithh2.entity.Student;
import com.mc.restwithh2.service.student.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentControllerImpl implements StudentController{
    private final StudentService studentService;

    public StudentControllerImpl(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Optional<List<StudentDto>> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/{studentId}")
    public Optional<Student> getStudent(@PathVariable Long studentId) {
        return studentService.findById(studentId);
    }

    @PostMapping
    public ResponseEntity<Object> saveStudent(@RequestBody StudentDto studentDto) {
        studentService.addStudent(studentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Object> updateStudent(@PathVariable Long studentId, @RequestBody StudentDto studentDto) {
        studentService.updateStudent(studentId, studentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Object> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
