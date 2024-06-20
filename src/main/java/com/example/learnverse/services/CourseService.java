package com.example.learnverse.services;

import com.example.learnverse.dto.CourseDto;
import com.example.learnverse.entities.Course;

import java.util.List;

public interface CourseService {
    CourseDto saveCourse(CourseDto courseDto);

    CourseDto getCourseById(Long id);

    Course findById(Long id);

    CourseDto updateCourse(Long id, CourseDto courseDto);

    boolean deleteCourse(Long id);
    List<CourseDto> findAllCourses();
}
