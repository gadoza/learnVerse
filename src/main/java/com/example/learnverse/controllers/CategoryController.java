package com.example.learnverse.controllers;

import com.example.learnverse.dto.ApiResponse;
import com.example.learnverse.dto.CategoryDto;
import com.example.learnverse.dto.CourseDto;
import com.example.learnverse.entities.Course;
import com.example.learnverse.mapper.CourseMapper;
import com.example.learnverse.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final CourseMapper courseMapper;
    @GetMapping
    public ApiResponse<Set<CategoryDto>> getAllCategories(){
        return ApiResponse.ok(categoryService.getAllCategories());
    }
    @GetMapping("/{id}/courses")
    public ApiResponse<Set<CourseDto>> getAllCategoryCourses(@PathVariable(name = "id") Long categoryId){
        Set<Course> categoryCourses = categoryService.getAllCategoryCourses(categoryId);
        return ApiResponse.ok(courseMapper.mapSet(categoryCourses));
    }
}
