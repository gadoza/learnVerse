package com.example.learnverse.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-12T22:52:41+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class InstructorMapperImpl implements InstructorMapper {

    @Override
    public InstructorDto map(Instructor t) {
        if ( t == null ) {
            return null;
        }

        InstructorDto instructorDto = new InstructorDto();

        return instructorDto;
    }

    @Override
    public Instructor unmap(InstructorDto dto) {
        if ( dto == null ) {
            return null;
        }

        Instructor instructor = new Instructor();

        return instructor;
    }
}
