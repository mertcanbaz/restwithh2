package com.mc.restwithh2.service.student;

import com.mc.restwithh2.entity.Student;
import com.mc.restwithh2.exception.ResourceNotFoundException;
import com.mc.restwithh2.repository.StudentRepository;
import com.mc.restwithh2.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findStudentById(id);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveAllStudents(List<Student> studentList) {
        studentRepository.saveAll(studentList);
    }

    @Override
    public void addStudent(Student student) {

        Optional<Student> studentByGivenEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByGivenEmail.isPresent()) {
            throw new ResourceNotFoundException("email is taken");
        }

        studentRepository.save(student);
    }

    @Override
    @Transactional
    public void updateStudent(Long studentId, Student student) {

        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new ResourceNotFoundException("student with id : " + studentId + " does not exists");
        }

        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new ResourceNotFoundException("student with id : " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }
}
