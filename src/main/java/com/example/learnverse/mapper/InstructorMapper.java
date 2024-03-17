package com.example.learnverse.mapper;

import com.example.learnverse.dto.InstructorDto;
import com.example.learnverse.entities.Instructor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    InstructorDto map(Instructor t);
    Instructor unmap(InstructorDto dto);
}
