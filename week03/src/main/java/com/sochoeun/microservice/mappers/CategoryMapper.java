package com.sochoeun.microservice.mappers;

import com.sochoeun.microservice.dto.request.CategoryRequest;
import com.sochoeun.microservice.dto.response.CategoryResponse;
import com.sochoeun.microservice.entities.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryEntity toEntity(CategoryRequest request){
        return CategoryEntity.builder()
                .name(request.getName())
                .build();
    }

    public CategoryResponse toResponse(CategoryEntity category){
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
