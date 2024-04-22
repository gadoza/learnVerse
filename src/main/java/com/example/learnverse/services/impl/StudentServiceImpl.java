package com.example.learnverse.services.impl;

import com.example.learnverse.dto.StudentDto;
import com.example.learnverse.entities.Course;
import com.example.learnverse.entities.Student;
import com.example.learnverse.mapper.CourseMapper;
import com.example.learnverse.mapper.StudentMapper;
import com.example.learnverse.repositories.CourseRepository;
import com.example.learnverse.repositories.StudentRepository;
import com.example.learnverse.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        Student student = studentRepository.save(studentMapper.unmap(studentDto));
        return studentMapper.map(student);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return studentMapper.map(student.get());
        }
        return null;
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            //TODO
//            student.setStudentName(StudentDto.getCourseName());
//            student.setDescription(StudentDto.getDescription());
//            student.setPrice(StudentDto.getPrice());
//
//            courseRepository.save(student);
            return studentMapper.map(student);
        }
        return null;
    }

    @Override
    public boolean deleteStudent(Long id) {
        //TODO
        return false;
    }
}
