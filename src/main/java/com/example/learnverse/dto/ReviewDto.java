package com.example.learnverse.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ReviewDto {
    private StudentDto student;
    private CourseDto course;
    private int nStars;
    private Date issueDate;
    private String description;
}
