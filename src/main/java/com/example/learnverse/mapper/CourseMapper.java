package com.example.learnverse.mapper;

import com.example.learnverse.dto.CourseDto;
import com.example.learnverse.entities.Course;
import com.example.learnverse.security.dto.JpaUserDto;
import com.example.learnverse.security.entities.JpaUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {
//    @Mapping(target = "courseName", source = "courseName")
    CourseDto map(Course t);
    Course unmap(CourseDto dto);
}
