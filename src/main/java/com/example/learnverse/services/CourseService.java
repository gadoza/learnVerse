package com.example.learnverse.services;

import com.example.learnverse.dto.CourseDto;

public interface CourseService {
    CourseDto saveCourse(CourseDto courseDto);

    CourseDto getCourseById(Long id);

    CourseDto updateCourse(Long id, CourseDto courseDto);

    boolean deleteCourse(Long id);
}
