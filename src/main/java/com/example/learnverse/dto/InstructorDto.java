package com.example.learnverse.dto;

import com.example.learnverse.entities.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class InstructorDto extends UserDto{
    private int id;
    private String intro;
    private List<Course> courses;
}
