package com.example.learnverse.security.service;

import com.example.learnverse.security.dto.JpaUserDto;
import com.example.learnverse.security.entities.JpaUser;

import java.util.Optional;

public interface JpaUserDetailsService {
    Long insertNewUser(JpaUserDto userDto);

    JpaUser getUserByUserName(String userName);
    JpaUserDto getCurrentUserDetails();
    Optional<JpaUser> findJpaUserById(Long id);

    JpaUserDto getCurrentUserDetailsById(Long userId);

    void updateUserDetails(JpaUserDto userDto);
}
