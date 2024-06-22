package com.example.learnverse.services;

import com.example.learnverse.entities.Course;
import com.example.learnverse.security.entities.JpaUser;

public interface EnrollmentService {
    void enroll(Course enrolledCourse, JpaUser enrolledStudent);

    void unenroll(Course enrolledCourse, JpaUser enrolledStudent);

    boolean checkEnrollment(Long courseId, Long studentId);
}
