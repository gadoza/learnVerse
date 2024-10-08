package com.example.learnverse.security.controllers;

import com.example.learnverse.dto.ApiResponse;
import com.example.learnverse.security.dto.AuthDto;
import com.example.learnverse.security.dto.JpaUserDto;
import com.example.learnverse.security.service.JpaUserDetailsService;
import com.example.learnverse.security.service.TokenService;
import com.example.learnverse.services.StripeService;
import com.stripe.exception.StripeException;
import com.example.learnverse.services.StripeService.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class AuthController {

    private final TokenService tokenService;
    private final JpaUserDetailsService jpaUserDetailsService;
    private final StripeService stripeService;

    @PostMapping("/sign-in")
    public AuthDto signIn(Authentication authentication, HttpServletResponse response) {
        AuthDto authDto = tokenService.generateToken(authentication);

        Cookie cookie = new Cookie("token", authDto.getToken());
        cookie.setHttpOnly(true); // Helps mitigate the risk of client side script accessing the protected cookie
        cookie.setPath("/"); // Specifies the path for the cookie to which the client should return the cookie
        cookie.setMaxAge(7 * 24 * 60 * 60); // Set max age of the cookie to 7 days (for example)
        response.addCookie(cookie);

        return authDto;
    }

    @PostMapping("/sign-up")
    public ApiResponse<Long> signUp(@RequestBody JpaUserDto userDto) throws StripeException {
        //add the user as a customer in stripe
        stripeService.createStripeCustomer(userDto);

        return ApiResponse.created(jpaUserDetailsService.insertNewUser(userDto));
    }


}
