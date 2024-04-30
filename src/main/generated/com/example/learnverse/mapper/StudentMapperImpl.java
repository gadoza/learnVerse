package com.example.learnverse.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-12T22:52:41+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentDto map(Student t) {
        if ( t == null ) {
            return null;
        }

        StudentDto studentDto = new StudentDto();

        return studentDto;
    }

    @Override
    public Student unmap(StudentDto dto) {
        if ( dto == null ) {
            return null;
        }

        Student student = new Student();

        return student;
    }
}
