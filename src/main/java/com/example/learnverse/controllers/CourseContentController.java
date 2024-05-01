package com.example.learnverse.controllers;

import com.example.learnverse.dto.ApiResponse;
import com.example.learnverse.dto.CourseMediaDto;
import com.example.learnverse.entities.CourseMedia;
import com.example.learnverse.services.CourseMediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/videos")
@RequiredArgsConstructor
public class CourseContentController {
    private final CourseMediaService courseMediaService;

    @PostMapping("/courses/{courseId}")
    public ApiResponse<CourseMediaDto> uploadVideo(@RequestParam("file") MultipartFile file, @PathVariable Long courseId) throws IOException {

        return ApiResponse.ok(courseMediaService.saveCourseVideo(file, courseId));
    }
    @GetMapping("/courses/{courseId}")
    public ApiResponse<List<CourseMediaDto>> getCourseVideos(@PathVariable Long courseId){
        return ApiResponse.ok(courseMediaService.getAllVideosByCourse(courseId));
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId){
        CourseMedia courseMedia = courseMediaService.getVideoById(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(courseMedia.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + courseMedia.getFilename()
                                + "\"")
                .body(new ByteArrayResource(courseMedia.getContent()));
    }
}
