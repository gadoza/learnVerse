package com.example.learnverse.controllers;

import com.example.learnverse.dto.EnrollmentDto;
import com.example.learnverse.entities.Course;
import com.example.learnverse.repositories.CourseRepository;
import com.example.learnverse.security.entities.JpaUser;
import com.example.learnverse.security.repositories.JpaUserRepository;
import com.example.learnverse.security.service.JpaUserDetailsService;
import com.example.learnverse.services.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/enrollment")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;
    private final CourseRepository courseRepository;
    private final JpaUserDetailsService jpaUserDetailsService;
    private final JpaUserRepository jpaUserRepository;

    @PostMapping
    ResponseEntity<Void> enroll(@RequestBody EnrollmentDto enrollmentDto){
        Course enrolledCourse = courseRepository.findCourseById(enrollmentDto.getCourseId()).get();
        JpaUser enrolledStudent = jpaUserDetailsService.findJpaUserById(enrollmentDto.getStudentId()).get();
        if(enrolledStudent == null){
            return ResponseEntity.notFound().build();
        }else if(enrolledCourse == null){
            return ResponseEntity.notFound().build();
        }
        enrollmentService.enroll(enrolledCourse, enrolledStudent);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    ResponseEntity<Void> unenroll(@RequestBody EnrollmentDto enrollmentDto){
        Course enrolledCourse = courseRepository.getReferenceById(enrollmentDto.getCourseId());
        JpaUser enrolledStudent = jpaUserRepository.getReferenceById(enrollmentDto.getStudentId());
        if(enrolledStudent == null){
            return ResponseEntity.notFound().build();
        }else if(enrolledCourse == null){
            return ResponseEntity.notFound().build();
        }
        enrollmentService.unenroll(enrolledCourse, enrolledStudent);
        return ResponseEntity.ok().build();
    }
    //TODO transfer logic to service
    //TODO get courses enrolled by student
}
