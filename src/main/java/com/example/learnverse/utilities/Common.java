package com.example.learnverse.utilities;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class Common {

    public static String extractUsername(JwtDecoder jwtDecoder) {
        Jwt jwt = jwtDecoder.decode(getToken());

        String username = jwt.getSubject();

        return username;
    }
    public static String getToken(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        JwtAuthenticationToken jwtToken = (JwtAuthenticationToken) authentication;
        return   jwtToken.getToken().getTokenValue();
    }
}
