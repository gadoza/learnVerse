package com.example.learnverse.mapper;

import com.example.learnverse.dto.StudentDto;
import com.example.learnverse.entities.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto map(Student t);
    Student unmap(StudentDto dto);

}
