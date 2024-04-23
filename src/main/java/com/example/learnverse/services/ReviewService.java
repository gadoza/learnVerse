package com.example.learnverse.services;

import com.example.learnverse.dto.CourseDto;
import com.example.learnverse.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    ReviewDto saveReview(ReviewDto reviewDto);

    ReviewDto getReviewById(Long id);

    ReviewDto updateReview(ReviewDto reviewDto);

    List<ReviewDto> findAllCourseReviews(Long id);

    boolean deleteReview(Long id);
}
