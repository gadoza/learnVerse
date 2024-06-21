package com.example.learnverse.security.service;

import com.example.learnverse.security.dto.JpaUserDto;

public interface JpaUserDetailsService {
    Long insertNewUser(JpaUserDto userDto);
    JpaUserDto getCurrentUserDetails();

    JpaUserDto getCurrentUserDetailsById(Long userId);

    void updateUserDetails(JpaUserDto userDto);
}
