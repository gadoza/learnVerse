package com.example.learnverse.mapper;

import com.example.learnverse.dto.TagDto;
import com.example.learnverse.entities.Tag;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-12T22:52:41+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public TagDto map(Tag t) {
        if ( t == null ) {
            return null;
        }

        TagDto tagDto = new TagDto();

        return tagDto;
    }

    @Override
    public Tag unmap(TagDto dto) {
        if ( dto == null ) {
            return null;
        }

        Tag tag = new Tag();

        return tag;
    }
}
