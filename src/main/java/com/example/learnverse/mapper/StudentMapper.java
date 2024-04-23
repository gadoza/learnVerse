package com.example.learnverse.mapper;

import com.example.learnverse.dto.StudentDto;
import com.example.learnverse.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {
//    @Mapping(target = "email", source = "email")
    StudentDto map(Student t);
//    @Mapping(target = "email", source = "email")
    Student unmap(StudentDto dto);

}
