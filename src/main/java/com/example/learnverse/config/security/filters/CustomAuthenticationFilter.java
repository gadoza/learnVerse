package com.example.learnverse.config.security.filters;

import com.example.learnverse.config.security.authentication.CustomAuthentication;
import com.example.learnverse.config.security.managers.CustomAuthenticationManager;
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

        // 1. create authentication object which is not yet authenticated
        // 2. delegate the authentication manager to the object
        // 3. get back the authentication from the manager
        // 4. if the object is authenticated send the request to the next filter in the chain

        String key = request.getHeader("key");

        CustomAuthentication authentication = new CustomAuthentication(key, false);

        Authentication authenticateObject = customAuthenticationManager.authenticate(authentication);

        if(authenticateObject.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(authenticateObject);
            filterChain.doFilter(request,response);
        }

    }
}
