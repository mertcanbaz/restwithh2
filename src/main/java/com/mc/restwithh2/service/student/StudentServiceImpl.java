package com.mc.restwithh2.service.student;

import com.mc.restwithh2.entity.Student;
import com.mc.restwithh2.exception.EmailTakenException;
import com.mc.restwithh2.exception.ResourceNotFoundException;
import com.mc.restwithh2.mapper.StudentMapper;
import com.mc.restwithh2.repository.StudentRepository;
import org.springframework.stereotype.Service;
import com.mc.restwithh2.dto.StudentDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public boolean existById(Long id) {
        return studentRepository.existsById(id);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Optional<List<StudentDto>> getStudents() {
        return Optional.ofNullable(studentMapper.entityListToDtoList(studentRepository.findAll()));
    }

//    @Override
//    public void saveAllStudents(List<StudentDto> studentDtoList) {
//        studentRepository.saveAllAndFlush(studentMapper.dtoListToEntityList(studentDtoList));
//    }

    @Override
    public void addStudent(StudentDto studentDto) {

        Optional<Student> studentByGivenEmail = studentRepository.findStudentByEmail(studentDto.getEmail());
        if (studentByGivenEmail.isPresent()) {
            throw new EmailTakenException("Email " + studentDto.getEmail() + "is taken!");
        }

        studentRepository.save(studentMapper.dtoToEntity(studentDto));
    }

    @Override
    @Transactional
    public void updateStudent(Long studentId, StudentDto studentDto) {

        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new ResourceNotFoundException("student with id : " + studentId + " does not exists");
        }

        Student studentToUpdate = studentMapper.dtoToEntity(studentDto);
        studentToUpdate.setId(studentId);
        studentRepository.save(studentToUpdate);
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
