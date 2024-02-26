package com.example.learnverse.config.filters;

import com.example.learnverse.config.authentication.CustomAuthentication;
import com.example.learnverse.config.managers.CustomAuthenticationManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private final CustomAuthenticationManager customAuthenticationManager;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String headerUserName = request.getHeader("userName");
        String headerPassword = request.getHeader("password");


        CustomAuthentication customAuthentication = new CustomAuthentication(false, headerUserName, headerPassword);

        Authentication authenticate = customAuthenticationManager.authenticate(customAuthentication);

        if(authenticate.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            filterChain.doFilter(request,response);
        }

    }
}
