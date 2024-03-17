package com.example.learnverse.mapper;

import com.example.learnverse.dto.TagDto;
import com.example.learnverse.entities.Tag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagDto map(Tag t);
    Tag unmap(TagDto dto);
}
