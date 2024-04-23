package com.example.learnverse.controllers;

import com.example.learnverse.dto.CourseDto;
import com.example.learnverse.dto.ReviewDto;
import com.example.learnverse.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    @GetMapping("/{id}")
    public ResponseEntity<ReviewDto> getReviewById(@PathVariable Long id){
        ReviewDto reviewDto = reviewService.getReviewById(id);
        if(reviewDto != null){
            return ResponseEntity.ok(reviewDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/course/{id}")
    public ResponseEntity<List<ReviewDto>> getCourseReviews(@PathVariable Long id){
        List<ReviewDto> reviewDtos = reviewService.findAllCourseReviews(id);
        if(reviewDtos != null){
            return ResponseEntity.ok(reviewDtos);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<ReviewDto> addReview(@RequestBody ReviewDto reviewDto){
        ReviewDto savedReview = reviewService.saveReview(reviewDto);
        return ResponseEntity.ok(savedReview);
    }
    @PutMapping
    public ResponseEntity<ReviewDto> updateReview(@RequestBody ReviewDto reviewDto) {
        ReviewDto updatedReview = reviewService.updateReview(reviewDto);
        if (updatedReview != null) {
            return ResponseEntity.ok(updatedReview);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id){
        boolean isDeleted = reviewService.deleteReview(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

