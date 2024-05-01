package com.example.learnverse.services.impl;

import com.example.learnverse.dto.CourseMediaDto;
import com.example.learnverse.entities.CourseMedia;
import com.example.learnverse.exceptions.BusinessException;
import com.example.learnverse.mapper.CourseMediaMapper;
import com.example.learnverse.repositories.CourseMediaRepository;
import com.example.learnverse.repositories.CourseRepository;
import com.example.learnverse.services.CourseMediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseMediaServiceImpl implements CourseMediaService {
    private final CourseMediaRepository courseMediaRepository;
    private final CourseRepository courseRepository;
    private final CourseMediaMapper courseMediaMapper;
    @Override
    public CourseMediaDto saveCourseVideo(MultipartFile file, Long courseId) throws IOException {
        CourseMedia courseMediaEntity = mapFileToCourseMediaEntity(file, courseId);
        CourseMediaDto courseMediaDto = courseMediaMapper.map(courseMediaRepository.save(courseMediaEntity));
        String downloadURl = getDownloadURl(courseMediaDto.getId());
        courseMediaDto.setContentUrl(downloadURl);
        return courseMediaDto;
    }

    private static String getDownloadURl(Long videoId) {
        String downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/videos/download/")
                .path(videoId.toString())
                .toUriString();
        return downloadURl;
    }

    private CourseMedia mapFileToCourseMediaEntity(MultipartFile file, Long courseId) throws IOException {
        CourseMedia courseMediaEntity = new CourseMedia();
        courseMediaEntity.setTitle(file.getOriginalFilename());
        courseMediaEntity.setFilename(file.getName());
        courseMediaEntity.setContentType(file.getContentType());
        courseMediaEntity.setDataSize(file.getSize());
        courseMediaEntity.setCourse(courseRepository.getReferenceById(courseId));
        courseMediaEntity.setContent(file.getBytes());
        return courseMediaEntity;
    }

    @Override
    @Transactional
    public List<CourseMediaDto> getAllVideosByCourse(Long courseId) {
        List<CourseMediaDto> courseMediaDTos = courseMediaMapper.map(courseMediaRepository.findAllByCourseId(courseId));
        courseMediaDTos.stream().forEach(courseMediaDTo -> {
            courseMediaDTo.setContentUrl(getDownloadURl(courseMediaDTo.getId()));
        });
        return courseMediaDTos;
    }

    @Override
    public CourseMedia getVideoById(Long fileId) {
        return courseMediaRepository.findById(fileId).orElseThrow(() -> new BusinessException("video not found", HttpStatus.NOT_FOUND));
    }
}
