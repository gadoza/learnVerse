package com.example.learnverse.mapper;

import com.example.learnverse.dto.InstructorDto;
import com.example.learnverse.entities.Instructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
//    @Mapping(target = "id", source = "id")
//@Mapping(target = "userName", source = "userName")
InstructorDto map(Instructor t);
//    @Mapping(target = "userName", source = "userName")
//    @Mapping(target = "id", source = "id")
    Instructor unmap(InstructorDto dto);
}
