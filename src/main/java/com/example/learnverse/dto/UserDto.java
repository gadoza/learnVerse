package com.example.learnverse.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class UserDto {
    private String username;
    private String email;
    private String address;
    private String firstName;
    private String familyName;
    private String password;
    private Date birthdate;
    private Date registerationDate;
}
