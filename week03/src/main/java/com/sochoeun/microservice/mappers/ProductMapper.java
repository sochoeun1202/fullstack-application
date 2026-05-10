package com.sochoeun.microservice.mappers;

import com.sochoeun.microservice.dto.request.ProductRequest;
import com.sochoeun.microservice.dto.response.ProductResponse;
import com.sochoeun.microservice.entities.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductEntity toEntity(ProductRequest request){
        return ProductEntity.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .price(request.getPrice())
                .discount(request.getDiscount())
                .build();
    }

    public ProductResponse toResponse(ProductEntity request){
        return ProductResponse.builder()
                .id(request.getId())
                .title(request.getTitle())
                .description(request.getDescription())
                .price(request.getPrice())
                .discount(request.getDiscount())
                .createdDate("")
                .build();
    }
}
