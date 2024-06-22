package com.example.learnverse.repositories;

import com.example.learnverse.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("""
    select c
    from Category c 
    where c.code in :codes
""")
    Set<Category> getCategoriesByCode(@Param("codes") List<String> codes);
}
