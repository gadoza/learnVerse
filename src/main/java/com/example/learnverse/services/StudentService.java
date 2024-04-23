package com.example.learnverse.services;

import com.example.learnverse.dto.CourseDto;
import com.example.learnverse.dto.StudentDto;

public interface StudentService {
    StudentDto saveStudent(StudentDto studentDto);
    StudentDto getStudentById(Long id);
    StudentDto updateStudent(Long id, StudentDto studentDto);
    boolean deleteStudent(Long id);
}

