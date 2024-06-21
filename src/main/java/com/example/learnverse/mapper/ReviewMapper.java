package com.example.learnverse.mapper;

import com.example.learnverse.dto.ReviewDto;
import com.example.learnverse.entities.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Base64;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    @Mapping(source = "user.image", target = "user.image", qualifiedByName = "convertImageFromBase64ToString")
    ReviewDto map(Review t);
    @Mapping(source = "user.image", target = "user.image", qualifiedByName = "convertImageFromStringToBase64")
    Review unmap(ReviewDto dto);

    List<ReviewDto> map(List<Review> t);
    List<Review> unmap(List<ReviewDto> dto);


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
