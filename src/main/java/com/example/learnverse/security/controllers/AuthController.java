package com.example.learnverse.security.controllers;

import com.example.learnverse.dto.ApiResponse;
import com.example.learnverse.security.dto.JpaUserDto;
import com.example.learnverse.security.service.JpaUserDetailsService;
import com.example.learnverse.security.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class AuthController {

    private final TokenService tokenService;
    private final JpaUserDetailsService jpaUserDetailsService;

    @PostMapping("/sign-in")
    public String signIn(Authentication authentication) {
        return tokenService.generateToken(authentication);
    }

    @PostMapping("/sign-up")
    public ApiResponse<Long> signUp(@RequestBody JpaUserDto userDto) {
        return ApiResponse.created(jpaUserDetailsService.insertNewUser(userDto)) ;
    }

}
