package com.example.learnverse.base.mapper;

import java.util.List;

public interface BaseMapper <T, DTO>{

    DTO map(T t);
    T unmap(DTO dto);

    List<DTO> map(List<T> t);
    List<T> unmap(List<DTO> dto);
}
