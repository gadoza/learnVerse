package com.example.learnverse.services;

import com.example.learnverse.entities.Course;
import com.example.learnverse.entities.Student;

public interface EnrollmentService {
    void enroll(Course enrolledCourse, Student enrolledStudent);

    void unenroll(Course enrolledCourse, Student enrolledStudent);
}
