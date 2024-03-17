package com.example.learnverse.dto;

import com.example.learnverse.entities.Course;
import com.example.learnverse.entities.Review;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class StudentDto extends UserDto{
    private int id;
    private String organization;
    private List<Course> courses;
    private List<Review> reviews;
}
