package com.example.learnverse.dto;

import com.example.learnverse.entities.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class TagDto {
    private String name;
    private List<Course> courses;
}
