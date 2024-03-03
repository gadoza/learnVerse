package com.example.learnverse.services;

import com.example.learnverse.entities.User;
import com.example.learnverse.repositories.UserRepository;
import com.example.learnverse.security.SecurityUser;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Service
//@RequiredArgsConstructor
public class JpaUserDetailsService /*implements UserDetailsService*/ {
//    private final UserRepository userRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Optional<User> userByUserName = userRepository.findUserByUserName(username);
//
//        return userByUserName.map(SecurityUser::new).orElseThrow(()->new UsernameNotFoundException("Username not found " + username));
//    }
}
