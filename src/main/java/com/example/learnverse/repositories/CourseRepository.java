package com.example.learnverse.repositories;

import com.example.learnverse.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    @Transactional
    @Query("""
            SELECT C FROM Course C WHERE C.id = :id and C.isDeleted = 0
            """)
    Optional<Course> findCourseById(@Param("id") Long id);

    @Transactional
    @Query("SELECT c FROM Course c WHERE lower(c.courseName) LIKE lower(concat('%', :searchString, '%'))")
    List<Course> findCoursesByNameContaining(@Param("searchString") String searchString);


    @Query("""
            SELECT C FROM Course C WHERE C.isDeleted = 0
            """)
    List<Course> findAllValidCourses();


//    @Query("""
//            SELECT AVG(e.n_stars) FROM Course e WHERE e.is_deleted = 1
//            """)
//    BigDecimal calculateCourseRating();

    @Modifying
    @Transactional
    @Query("""
        update Course 
        set isDeleted = 1 
        where id = :id
""")
    void softDeleteCourseById(@Param("id") Long id);

    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM JpaUser s JOIN s.takenCourses c WHERE s.id = :studentId AND c.id = :courseId")
    boolean existsStudentWithCourse(@Param("studentId") Long studentId, @Param("courseId") Long courseId);


}
