package com.example.learnverse.mapper;

import com.example.learnverse.dto.CourseDto;
import com.example.learnverse.entities.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Base64;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(source = "image", target = "image", qualifiedByName = "convertImageFromBase64ToString")
    CourseDto map(Course t);
    @Mapping(source = "image", target = "image", qualifiedByName = "convertImageFromStringToBase64")
    Course unmap(CourseDto dto);

    @Named("convertImageFromBase64ToString")
    default String  convertImageFromBase64ToString(byte [] image){
        if(image == null) return null;
        return Base64.getEncoder().encodeToString(image);
    }
    @Named("convertImageFromStringToBase64")
    default byte[]  convertImageFromStringToBase64(String image){
        if(image == null) return null;
        return Base64.getDecoder().decode(image);
    }

}
