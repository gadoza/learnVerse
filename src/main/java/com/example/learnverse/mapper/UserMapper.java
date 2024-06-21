package com.example.learnverse.mapper;

import com.example.learnverse.security.dto.JpaUserDto;
import com.example.learnverse.security.entities.JpaUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Base64;

@Mapper(componentModel = "spring")
public interface UserMapper{

//    @Mapping(target = "email", source = "email")
//    @Mapping(target = "createdDate", source = "createdDate")
    @Mapping(source = "image", target = "image", qualifiedByName = "convertImageFromBase64ToString")
    JpaUserDto map(JpaUser t);
//    @Mapping(target = "createdDate", source = "createdDate")
//    @Mapping(target = "email", source = "email")
    @Mapping(source = "image", target = "image", qualifiedByName = "convertImageFromStringToBase64")
    JpaUser unmap(JpaUserDto dto);

    @Named("convertImageFromBase64ToString")
    default String  convertImageFromBase64ToString(byte [] image){
        if(image == null) return null;
        return Base64.getEncoder().encodeToString(image);
    }
    @Named("convertImageFromStringToBase64")
    default byte[]  convertImageFromStringToBase64(String image){
        if(image == null) return null;
        return Base64.getDecoder().decode(image);
    }
}
