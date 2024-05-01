package com.example.learnverse.mapper;

import com.example.learnverse.dto.CourseMediaDto;
import com.example.learnverse.entities.CourseMedia;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.Base64;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMediaMapper {
    CourseMediaDto map(CourseMedia t);
    CourseMedia unmap(CourseMediaDto dto);

    List<CourseMediaDto> map(List<CourseMedia> t);
    List<CourseMedia> unmap(List<CourseMediaDto> dto);

}
