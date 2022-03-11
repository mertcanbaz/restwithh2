package com.mc.restwithh2.mapper;

import com.mc.restwithh2.dto.StudentDto;
import com.mc.restwithh2.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class StudentMapper {
    public abstract Student dtoToEntity(StudentDto studentDto);
    public abstract StudentDto entityToDto(Student student);

    public abstract List<Student> dtoListToEntityList(List<StudentDto> studentDtoList);
    public abstract List<StudentDto> entityListToDtoList(List<Student> studentList);
}
