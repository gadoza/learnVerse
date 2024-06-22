package com.example.learnverse.services.impl;

import com.example.learnverse.dto.CategoryDto;
import com.example.learnverse.entities.Category;
import com.example.learnverse.entities.Course;
import com.example.learnverse.mapper.CategoryMapper;
import com.example.learnverse.repositories.CategoryRepository;
import com.example.learnverse.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public Set<Category> getCategoriesByCode(List<String> codes) {
        return categoryRepository.getCategoriesByCode(codes);
    }

    @Override
    public Set<CategoryDto> getAllCategories() {
        return categoryMapper.mapList(new HashSet<>(categoryRepository.findAll()));
    }

    @Override
    @Transactional
    public Set<Course> getAllCategoryCourses(Long id) {
        return categoryRepository.findById(id).get().getCourses();
    }
}
