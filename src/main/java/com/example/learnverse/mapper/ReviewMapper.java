package com.example.learnverse.mapper;

import com.example.learnverse.dto.ReviewDto;
import com.example.learnverse.entities.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewDto map(Review t);
    Review unmap(ReviewDto dto);
}
