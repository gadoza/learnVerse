package com.example.learnverse.mapper;

import com.example.learnverse.dto.CourseDto;
import com.example.learnverse.entities.Course;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-12T22:52:41+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class CourseMapperImpl implements CourseMapper {

    @Override
    public CourseDto map(Course t) {
        if ( t == null ) {
            return null;
        }

        CourseDto courseDto = new CourseDto();

        return courseDto;
    }

    @Override
    public Course unmap(CourseDto dto) {
        if ( dto == null ) {
            return null;
        }

        Course course = new Course();

        return course;
    }
}
