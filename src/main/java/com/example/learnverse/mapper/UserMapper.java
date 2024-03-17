package com.example.learnverse.mapper;

import com.example.learnverse.security.dto.JpaUserDto;
import com.example.learnverse.security.entities.JpaUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper{

    JpaUserDto map(JpaUser t);
    JpaUser unmap(JpaUserDto dto);
}
