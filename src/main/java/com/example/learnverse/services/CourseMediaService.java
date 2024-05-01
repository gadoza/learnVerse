package com.example.learnverse.services;

import com.example.learnverse.dto.CourseMediaDto;
import com.example.learnverse.entities.CourseMedia;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CourseMediaService {
    CourseMediaDto saveCourseVideo(MultipartFile file, Long courseId) throws IOException;

    List<CourseMediaDto> getAllVideosByCourse(Long courseId);

    CourseMedia getVideoById(Long fileId);
}
