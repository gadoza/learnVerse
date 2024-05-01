package com.example.learnverse.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class CourseMediaDto {
    private Long id;
    private String title;
    private String filename;
    private String contentType;
    private long dataSize;
    private String contentUrl;
}
