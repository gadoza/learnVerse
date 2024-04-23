package com.example.learnverse.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ReviewDto {
    private StudentDto student;
    private CourseDto course;
//    private Long stars;
    private Date issueDate;
    private String content;
    private Long id;
}
