package com.example.learnverse.services.impl;

import com.example.learnverse.dto.CategoryDto;
import com.example.learnverse.dto.CourseDto;
import com.example.learnverse.entities.Category;
import com.example.learnverse.entities.Course;
import com.example.learnverse.mapper.CategoryMapper;
import com.example.learnverse.mapper.CourseMapper;
import com.example.learnverse.repositories.CourseRepository;
import com.example.learnverse.services.CategoryService;
import com.example.learnverse.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @Override
    public CourseDto saveCourse(CourseDto courseDto) {
        Course courseEntity = courseMapper.unmap(courseDto);
        Set<Category> courseCategories = categoryService.getCategoriesByCode(courseDto.getCategoryCodes());
        courseEntity.setCategories(courseCategories);
        Course course = courseRepository.save(courseEntity);
        return courseMapper.map(course);
    }
    @Override
    @Transactional
    public CourseDto getCourseById(Long id) {
        Optional<Course> course = courseRepository.findCourseById(id);
        if (course.isPresent()) {
            return courseMapper.map(course.get());
        }
        return null;
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findCourseById(id).get();
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

    /*
    * TODO: improve effiecieny(don't fetech student from DB)
    * */
    @Override
    @Transactional
    public List<CourseDto> findAllCourses() {
        return courseMapper.map(courseRepository.findAllValidCourses());
    }
}
