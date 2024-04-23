package com.example.learnverse.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Setter
@Getter
public class CourseDto {
    private Long id;
    private String courseName;
    private String description;
    private BigDecimal price;
    private List<TagDto> tags;
    private List<ReviewDto> reviews;
    private List<InstructorDto> instructors;
    private Set<StudentDto> students;
    private String image;
}
