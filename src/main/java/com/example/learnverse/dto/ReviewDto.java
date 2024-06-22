package com.example.learnverse.dto;

import com.example.learnverse.security.dto.JpaUserDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ReviewDto {
    private JpaUserDto user;
    private Long stars;
    private Date issueDate;
    private String content;
    private Long courseId;
    private Long reviewId;
    private Long studentId;
}
