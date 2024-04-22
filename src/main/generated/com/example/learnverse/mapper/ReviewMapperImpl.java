package com.example.learnverse.mapper;

import com.example.learnverse.dto.ReviewDto;
import com.example.learnverse.entities.Review;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-12T22:52:41+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public ReviewDto map(Review t) {
        if ( t == null ) {
            return null;
        }

        ReviewDto reviewDto = new ReviewDto();

        return reviewDto;
    }

    @Override
    public Review unmap(ReviewDto dto) {
        if ( dto == null ) {
            return null;
        }

        Review review = new Review();

        return review;
    }
}
