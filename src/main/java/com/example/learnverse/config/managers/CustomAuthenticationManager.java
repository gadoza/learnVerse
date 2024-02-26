package com.example.learnverse.config.managers;

import com.example.learnverse.config.providers.CustomAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {
    private final CustomAuthenticationProvider provider;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if(provider.supports(authentication.getClass())){
            return provider.authenticate(authentication);
        }
        throw new BadCredentialsException("Oh No!");
    }
}
