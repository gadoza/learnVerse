package com.example.learnverse.repositories;

import com.example.learnverse.entities.Course;
import com.example.learnverse.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCourseId(Long id);
    @Modifying
    @Transactional
    @Query("""
        update Review 
        set isDeleted = 1 
        where id = :id
""")
    void softDeleteReviewById(@Param("id") Long id);
}
