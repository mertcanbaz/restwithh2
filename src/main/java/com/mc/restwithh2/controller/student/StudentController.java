package com.mc.restwithh2.controller.student;

import com.mc.restwithh2.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
public interface StudentController {

    @GetMapping
    List<Student> getStudents();

    @GetMapping("/{studentId}")
    Optional<Student> getStudent(@PathVariable Long studentId);

    @PostMapping
    ResponseEntity<Object> saveStudent(@RequestBody Student student);

    @PutMapping("/{studentId}")
    ResponseEntity<Object> updateStudent(@PathVariable Long studentId, @RequestBody Student student);

    @DeleteMapping("/{studentId}")
    ResponseEntity<Object> deleteStudent(@PathVariable Long studentId);

}
