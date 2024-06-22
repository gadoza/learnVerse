package com.example.learnverse.mapper;

import com.example.learnverse.dto.CategoryDto;
import com.example.learnverse.entities.Category;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto map(Category category);
    Set<CategoryDto> mapList(Set<Category> category);
    Category unMap(CategoryDto categoryDto);
    Set<Category> unMapList(Set<CategoryDto> categoryDto);

}
