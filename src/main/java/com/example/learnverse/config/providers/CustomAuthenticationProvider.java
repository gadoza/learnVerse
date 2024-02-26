package com.example.learnverse.config.providers;

import com.example.learnverse.config.authentication.CustomAuthentication;
import com.example.learnverse.config.managers.CustomAuthenticationManager;
import com.example.learnverse.entities.User;
import com.example.learnverse.services.JpaUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final JpaUserDetailsService jpaUserDetailsService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomAuthentication ca = (CustomAuthentication) authentication;
        User userByUserName = jpaUserDetailsService.findUserByUserName(ca.getUserName());
        if(ca.getPassword().equals(userByUserName.getPassword())){
            return new CustomAuthentication(true, null, null);
        }
        throw new BadCredentialsException("Oh No!");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuthentication.class.equals(authentication);
    }
}
