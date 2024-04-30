package com.example.learnverse.dto;

import com.example.learnverse.security.entities.JpaUser;
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
    private List<JpaUser> instructors;
    private Set<JpaUser> students;
    private String image;
}
