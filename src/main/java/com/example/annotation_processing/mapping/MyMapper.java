package com.example.annotation_processing.mapping;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MyMapper {

    Target map(Source source);
}