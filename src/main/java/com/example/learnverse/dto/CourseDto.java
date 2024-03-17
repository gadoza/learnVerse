package com.example.learnverse.dto;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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
    private List<StudentDto> students;
}
