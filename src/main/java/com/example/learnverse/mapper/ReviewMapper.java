package com.example.learnverse.mapper;

import com.example.learnverse.dto.ReviewDto;
import com.example.learnverse.entities.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
//    @Mapping(target = "description", source = "description")
    ReviewDto map(Review t);
//    @Mapping(target = "description", source = "description")
    Review unmap(ReviewDto dto);

    List<ReviewDto> map(List<Review> t);
    List<Review> unmap(List<ReviewDto> dto);
}
