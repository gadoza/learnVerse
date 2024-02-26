package com.example.learnverse.services.impl;

import com.example.learnverse.entities.User;
import com.example.learnverse.repositories.UserRepository;
import com.example.learnverse.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsServiceImpl implements UserDetailsService, com.example.learnverse.services.JpaUserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> userByUserName = userRepository.findUserByUserName(userName);

        return userByUserName.map(SecurityUser::new).orElseThrow(()->new UsernameNotFoundException("Username not found " + userName));
    }


    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findUserByUserName(userName).orElseThrow(()-> new UsernameNotFoundException("Username not found " + userName));
    }
}
