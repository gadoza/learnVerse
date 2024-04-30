package com.example.learnverse.mapper;

import com.example.learnverse.dto.ReviewDto;
import com.example.learnverse.entities.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Base64;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewDto map(Review t);
    Review unmap(ReviewDto dto);

    List<ReviewDto> map(List<Review> t);
    List<Review> unmap(List<ReviewDto> dto);


}
