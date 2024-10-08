package com.example.learnverse.services.impl;

import com.example.learnverse.dto.ReviewDto;
import com.example.learnverse.entities.Course;
import com.example.learnverse.entities.Review;
import com.example.learnverse.mapper.ReviewMapper;
import com.example.learnverse.repositories.ReviewRepository;
import com.example.learnverse.security.service.JpaUserDetailsService;
import com.example.learnverse.services.CourseService;
import com.example.learnverse.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final CourseService courseService;
    private final JpaUserDetailsService jpaUserDetailsService;

    @Transactional
    @Override
    public ReviewDto saveReview(ReviewDto reviewDto) {
        Review reviewEntity = reviewMapper.unmap(reviewDto);
        reviewEntity.setCourse(courseService.findById(reviewDto.getCourseId()));
        reviewEntity.setUser(jpaUserDetailsService.findJpaUserById(reviewDto.getStudentId()).get());
        Review review = reviewRepository.save(reviewEntity);
        return reviewMapper.map(review);
    }

    @Override
    public ReviewDto getReviewById(Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        System.out.println(review);
        if (review.isPresent() && review.get().getIsDeleted() != 1) {
            return reviewMapper.map(review.get());
        }
        return null;
    }

    @Override
    public ReviewDto updateReview(ReviewDto reviewDto) {
        Optional<Review> existingReview = reviewRepository.findById(reviewDto.getReviewId());
        if (existingReview.isPresent()) {
            Review review = existingReview.get();

            review.setStars(reviewDto.getStars());
            review.setContent(reviewDto.getContent());



            reviewRepository.save(review);
            return reviewMapper.map(review);
        }
        return null;
    }

    @Override
    public List<ReviewDto> findAllCourseReviews(Long id) {
        List<Review> reviews = reviewRepository.findByCourseId(id);
        if(reviews!=null){
            return reviewMapper.map(reviews);
        }
        return null;
    }

    @Override
    public boolean deleteReview(Long id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.softDeleteReviewById(id);
            return true;
        }
        return false;
    }
}
