package com.example.learnverse.security.service.impl;

import com.example.learnverse.security.decorators.SecurityJpaUser;
import com.example.learnverse.security.entities.JpaUser;
import com.example.learnverse.security.repositories.JpaUserRepository;
import com.example.learnverse.security.service.JpaUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsServiceImpl implements UserDetailsService, JpaUserDetailsService {
    private final JpaUserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JpaUser user = userRepository.findJpaUsersByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new User(user.getUserName(), user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("read")));
    }
}
