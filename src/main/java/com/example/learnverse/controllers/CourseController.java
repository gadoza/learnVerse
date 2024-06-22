package com.example.learnverse.controllers;

import com.example.learnverse.dto.CourseDto;

import com.example.learnverse.services.CourseService;
import com.example.learnverse.services.StripeService;
import com.stripe.exception.StripeException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final StripeService stripeService;

    @PostMapping
    public ResponseEntity<CourseDto> addCourse(@RequestBody CourseDto courseDto) throws StripeException {
        courseDto.setImage(courseDto.getImage().substring(22));
        CourseDto savedCourse = courseService.saveCourse(courseDto);

        //add the course as a product in stripe
        stripeService.createStripeProduct(courseDto);


        return ResponseEntity.ok(savedCourse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable Long id) {
        CourseDto courseDto = courseService.getCourseById(id);
        if (courseDto != null) {
            return ResponseEntity.ok(courseDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<CourseDto>> getCoursesByKeyword(@RequestParam(name = "q") String keyword) {
        keyword.replace("%20", " ");
        List<CourseDto> coursesDtos = courseService.getCoursesByKeyword(keyword);
        return ResponseEntity.ok(coursesDtos);
    }
    @GetMapping
    public ResponseEntity<List<CourseDto>> getCourses() {
        List<CourseDto> courseDtos = courseService.findAllCourses();
        if (courseDtos != null) {
            return ResponseEntity.ok(courseDtos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable Long id, @RequestBody CourseDto courseDto) {
        CourseDto updatedCourse = courseService.updateCourse(id, courseDto);
        if (updatedCourse != null) {
            return ResponseEntity.ok(updatedCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        boolean isDeleted = courseService.deleteCourse(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
