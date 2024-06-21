package com.example.learnverse.security.service.impl;

import com.example.learnverse.exceptions.BusinessException;
import com.example.learnverse.mapper.UserMapper;
import com.example.learnverse.security.dto.JpaUserDto;
import com.example.learnverse.security.entities.JpaUser;
import com.example.learnverse.security.repositories.JpaUserRepository;
import com.example.learnverse.security.service.JpaUserDetailsService;
import com.example.learnverse.utilities.Common;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsServiceImpl implements UserDetailsService, JpaUserDetailsService {

    private final JpaUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtDecoder jwtDecoder;
    private final UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = userRepository.findPasswordByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new User(username, password, Collections.singletonList(new SimpleGrantedAuthority("read")));
    }

    @Override
    public Long insertNewUser(JpaUserDto userDto) {
        validateUserName(userDto);
        JpaUser user = userMapper.unmap(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(user).getId();
    }

    @Override
    @Transactional
    public JpaUserDto getCurrentUserDetails() {
        String username = Common.extractUsername(jwtDecoder);
        JpaUser user = userRepository.findJpaUsersByUserName(username).orElseThrow(() -> new BusinessException("user not found", HttpStatus.NOT_FOUND));
        JpaUserDto userDto = userMapper.map(user);
        userDto.setPassword(null);
        return userDto;
    }
    @Override
    @Transactional
    public JpaUserDto getCurrentUserDetailsById(Long userId) {
        JpaUser user = userRepository.findById(userId).orElseThrow(() -> new BusinessException("user not found", HttpStatus.NOT_FOUND));
        JpaUserDto userDto = userMapper.map(user);
        userDto.setPassword(null);
        return userDto;
    }

    @Override
    public void updateUserDetails(JpaUserDto userDto) {
        userRepository.save(userMapper.unmap(userDto));
    }

    private void validateUserName(JpaUserDto userDto) {
        Optional<JpaUser> user = userRepository.findJpaUsersByUserName(userDto.getUserName());
        if (user.isPresent()) {
            throw new BusinessException("userName is already taken by someone else", HttpStatus.CONFLICT);
        }
    }
}
