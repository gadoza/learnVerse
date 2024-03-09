package com.example.learnverse.mapper;

import com.example.learnverse.base.mapper.BaseMapper;
import com.example.learnverse.security.dto.JpaUserDto;
import com.example.learnverse.security.entities.JpaUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<JpaUser, JpaUserDto> {
}
