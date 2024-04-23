package com.example.learnverse.mapper;

import com.example.learnverse.security.dto.JpaUserDto;
import com.example.learnverse.security.entities.JpaUser;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-12T22:52:41+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public JpaUserDto map(JpaUser t) {
        if ( t == null ) {
            return null;
        }

        JpaUserDto jpaUserDto = new JpaUserDto();

        return jpaUserDto;
    }

    @Override
    public JpaUser unmap(JpaUserDto dto) {
        if ( dto == null ) {
            return null;
        }

        JpaUser jpaUser = new JpaUser();

        return jpaUser;
    }
}
