package com.example.learnverse.controllers;

import com.example.learnverse.dto.ApiResponse;
import com.example.learnverse.security.dto.JpaUserDto;
import com.example.learnverse.security.service.JpaUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
        userDto.setImage(img.substring(22));
        jpaUserDetailsService.updateUserDetails(userDto) ;
        return ApiResponse.noContent();
    }

}
