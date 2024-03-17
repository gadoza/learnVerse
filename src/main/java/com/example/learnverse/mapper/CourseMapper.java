package com.example.learnverse.mapper;

import com.example.learnverse.dto.CourseDto;
import com.example.learnverse.entities.Course;
import com.example.learnverse.security.dto.JpaUserDto;
import com.example.learnverse.security.entities.JpaUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDto map(Course t);
    Course unmap(CourseDto dto);
}
