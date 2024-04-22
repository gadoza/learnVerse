package com.example.learnverse.mapper;

import com.example.learnverse.security.dto.JpaUserDto;
import com.example.learnverse.security.entities.JpaUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper{

//    @Mapping(target = "email", source = "email")
//    @Mapping(target = "createdDate", source = "createdDate")
    JpaUserDto map(JpaUser t);
//    @Mapping(target = "createdDate", source = "createdDate")
//    @Mapping(target = "email", source = "email")
    JpaUser unmap(JpaUserDto dto);
}
