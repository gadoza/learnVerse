package com.example.learnverse.repositories;

import com.example.learnverse.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    @Query("""
            SELECT C FROM Course C WHERE C.id = :id and C.isDeleted = 0
            """)
    Optional<Course> findCourseById(@Param("id") Long id);

    @Query("""
            SELECT C FROM Course C WHERE C.isDeleted = 0
            """)
    List<Course> findAllValidCourses();



    @Modifying
    @Transactional
    @Query("""
        update Course 
        set isDeleted = 1 
        where id = :id
""")
    void softDeleteCourseById(@Param("id") Long id);


}
