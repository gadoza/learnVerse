package com.example.learnverse.controllers;

import com.example.learnverse.dto.ApiResponse;
import com.example.learnverse.dto.CourseDto;
import com.example.learnverse.security.dto.JpaUserDto;
import com.example.learnverse.security.service.JpaUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final JpaUserDetailsService jpaUserDetailsService;

    @GetMapping()
    public ApiResponse<JpaUserDto> getUserDetails() {
        return ApiResponse.ok(jpaUserDetailsService.getCurrentUserDetails()) ;
    }
    @GetMapping("/{id}")
    public ApiResponse<JpaUserDto> getCurrentUserDetailsById(@PathVariable(name = "id") Long userId) {
        return ApiResponse.ok(jpaUserDetailsService.getCurrentUserDetailsById(userId)) ;
    }
    @PutMapping()
    public ApiResponse updateUserDetails(@RequestBody JpaUserDto userDto) {
        String img = userDto.getImage();
        if (img != null) {
            String[] splitedBase64Image = img.split(",");
            userDto.setImage(splitedBase64Image[1]);
        }
        jpaUserDetailsService.updateUserDetails(userDto) ;
        return ApiResponse.noContent();
    }
    @GetMapping("/{id}/courses")
    public ApiResponse<List<CourseDto>> getAllCoursesForStudent(@PathVariable(name = "id") Long userId){
        return ApiResponse.ok(jpaUserDetailsService.getAllCoursesForStudent(userId));
    }

}
