package com.example.learnverse.mapper;

import com.example.learnverse.dto.CourseDto;
import com.example.learnverse.dto.ReviewDto;
import com.example.learnverse.entities.Course;
import com.example.learnverse.entities.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Base64;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(source = "image", target = "image", qualifiedByName = "convertImageFromBase64ToString")
    CourseDto map(Course t);
    @Mapping(source = "image", target = "image", qualifiedByName = "convertImageFromStringToBase64")
    Course unmap(CourseDto dto);

    List<CourseDto> map(List<Course> t);
    List<Course> unmap(List<CourseDto> dto);

    List<ReviewDto> mapReviews(List<Review> reviews);

    // Additional mapping method for Review to ReviewDto
    @Mapping(source = "user.image", target = "user.image", qualifiedByName = "convertImageFromBase64ToString")
    ReviewDto mapReview(Review review);

    @Mapping(source = "user.image", target = "user.image", qualifiedByName = "convertImageFromStringToBase64")
    Review unmapReview(ReviewDto dto);

    List<Review> unmapReviews(List<ReviewDto> dto);


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
