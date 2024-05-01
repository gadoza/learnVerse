package com.example.learnverse.repositories;

import com.example.learnverse.entities.CourseMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseMediaRepository extends JpaRepository<CourseMedia, Long> {
    List<CourseMedia> findAllByCourseId(Long courseId);

    @Modifying
    @Query("""
    update CourseMedia cm
    set cm.isDeleted = 1
    where cm.id = :videoId
""")
    void softDeleteVideoById(@Param("videoId") Long videoId);
}
