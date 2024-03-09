package com.example.learnverse.security.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JpaUserDto {
    private String userName;
    private String password;
    private String email;
    private String address;
    private String firstName;
    private String familyName;
}
