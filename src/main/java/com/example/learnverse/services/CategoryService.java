package com.example.learnverse.services;

import com.example.learnverse.dto.CategoryDto;
import com.example.learnverse.entities.Category;
import com.example.learnverse.entities.Course;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    Set<Category> getCategoriesByCode(List<String> codes);

    Set<CategoryDto> getAllCategories();

    Set<Course> getAllCategoryCourses(Long id);
}
