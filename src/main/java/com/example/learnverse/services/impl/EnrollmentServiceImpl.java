package com.example.learnverse.services.impl;

import com.example.learnverse.entities.Course;
import com.example.learnverse.security.entities.JpaUser;
import com.example.learnverse.security.repositories.JpaUserRepository;
import com.example.learnverse.services.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
    private final JpaUserRepository jpaUserRepository;
    @Transactional
    @Override
    public void enroll(Course enrolledCourse, JpaUser enrolledStudent) {
        enrolledStudent.getTakenCourses().add(enrolledCourse);
        enrolledCourse.getStudents().add(enrolledStudent);

        jpaUserRepository.save(enrolledStudent);
    }

    @Transactional
    @Override
    public void unenroll(Course enrolledCourse, JpaUser enrolledStudent) {
        enrolledStudent.getTakenCourses().remove(enrolledCourse);
        enrolledCourse.getStudents().remove(enrolledStudent);

        jpaUserRepository.save(enrolledStudent);
    }
}
