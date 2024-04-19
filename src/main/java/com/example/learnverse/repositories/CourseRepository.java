package com.example.learnverse.repositories;

import com.example.learnverse.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course,Long> {
    @Query("""
            SELECT C FROM Course C WHERE C.courseName = :courseName
            """)
    Optional<Course> findCourseByCourseName(@Param("courseName") String courseName);

    @Modifying
    @Transactional
    @Query("""
        update Course 
        set isDeleted = 1 
        where id = :id
""")
    void softDeleteCourseById(@Param("id") Long id);
}
