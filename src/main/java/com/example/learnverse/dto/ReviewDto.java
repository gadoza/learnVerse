package com.example.learnverse.dto;

import com.example.learnverse.security.dto.JpaUserDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ReviewDto {
    private JpaUserDto user;
    private Long n_stars;
    private Date issueDate;
    private String content;
    private Long id;
}
