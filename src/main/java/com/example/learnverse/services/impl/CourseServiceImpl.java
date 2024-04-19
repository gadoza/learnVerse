package com.example.learnverse.services.impl;

import com.example.learnverse.dto.CourseDto;
import com.example.learnverse.entities.Course;
import com.example.learnverse.mapper.CourseMapper;
import com.example.learnverse.repositories.CourseRepository;
import com.example.learnverse.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public CourseDto saveCourse(CourseDto courseDto) {
        Course course = courseRepository.save(courseMapper.unmap(courseDto));
        return courseMapper.map(course);
    }
    @Override
    public CourseDto getCourseById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            return courseMapper.map(course.get());
        }
        return null;
    }
    @Override
    public CourseDto updateCourse(Long id, CourseDto courseDto) {
        Optional<Course> existingCourse = courseRepository.findById(id);
        if (existingCourse.isPresent()) {
            Course course = existingCourse.get();
            course.setCourseName(courseDto.getCourseName());
            course.setDescription(courseDto.getDescription());
            course.setPrice(courseDto.getPrice());
            if (courseDto.getImage() != null) {
                course.setImage(Base64.getDecoder().decode(courseDto.getImage()));
            }
            courseRepository.save(course);
            return courseMapper.map(course);
        }
        return null;
    }

    @Override
    public boolean deleteCourse(Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.softDeleteCourseById(id);
            return true;
        }
        return false;
    }

}
