package com.example.learnverse.services.impl;

import com.example.learnverse.entities.Course;
import com.example.learnverse.entities.Student;
import com.example.learnverse.repositories.StudentRepository;
import com.example.learnverse.services.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
    private final StudentRepository studentRepository;
    @Transactional
    @Override
    public void enroll(Course enrolledCourse, Student enrolledStudent) {
        enrolledStudent.getCourses().add(enrolledCourse);
        enrolledCourse.getStudents().add(enrolledStudent);

        studentRepository.save(enrolledStudent);
    }

    @Transactional
    @Override
    public void unenroll(Course enrolledCourse, Student enrolledStudent) {
        enrolledStudent.getCourses().remove(enrolledCourse);
        enrolledCourse.getStudents().remove(enrolledStudent);

        studentRepository.save(enrolledStudent);
    }
}
