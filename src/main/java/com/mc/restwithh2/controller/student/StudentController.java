package com.mc.restwithh2.controller.student;

import com.mc.restwithh2.entity.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
@Api(value = "Student API Documentation")
public interface StudentController {

    @GetMapping
    @ApiOperation(value="retuns all students")
    List<Student> getStudents();

    @GetMapping("/{studentId}")
    @ApiOperation(value="returns student by studentId")
    Optional<Student> getStudent(@PathVariable Long studentId);

    @PostMapping
    @ApiOperation(value="saves student")
    ResponseEntity<Object> saveStudent(@RequestBody Student student);

    @PutMapping("/{studentId}")
    @ApiOperation(value="updates student by studentId")
    ResponseEntity<Object> updateStudent(@PathVariable Long studentId, @RequestBody Student student);

    @DeleteMapping("/{studentId}")
    @ApiOperation(value="deletes student by studentId")
    ResponseEntity<Object> deleteStudent(@PathVariable Long studentId);

}
