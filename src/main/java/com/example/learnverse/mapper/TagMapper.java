package com.example.learnverse.mapper;

import com.example.learnverse.dto.TagDto;
import com.example.learnverse.entities.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TagMapper {
//    @Mapping(target = "id", source = "id")

    TagDto map(Tag t);
//    @Mapping(target = "id", source = "id")

    Tag unmap(TagDto dto);
}
