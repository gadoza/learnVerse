package com.example.learnverse.services;

import com.example.learnverse.entities.User;

public interface JpaUserDetailsService {
    User findUserByUserName(String userName);
}
