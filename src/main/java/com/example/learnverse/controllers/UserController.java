package com.example.learnverse.controllers;

import com.example.learnverse.dto.ApiResponse;
import com.example.learnverse.security.dto.JpaUserDto;
import com.example.learnverse.security.service.JpaUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final JpaUserDetailsService jpaUserDetailsService;

    @GetMapping()
    public ApiResponse<JpaUserDto> getCurrentUserDetails() {
        return ApiResponse.created(jpaUserDetailsService.getCurrentUserDetails()) ;
    }

}
