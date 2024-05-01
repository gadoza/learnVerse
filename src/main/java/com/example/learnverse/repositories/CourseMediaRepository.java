package com.example.learnverse.repositories;

import com.example.learnverse.entities.CourseMedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseMediaRepository extends JpaRepository<CourseMedia, Long> {
    List<CourseMedia> findAllByCourseId(Long courseId);
}
