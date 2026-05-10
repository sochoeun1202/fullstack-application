package com.sochoeun.microservice.services.impl;

import com.sochoeun.microservice.entities.ProductEntity;
import com.sochoeun.microservice.repositories.ProductRepository;
import com.sochoeun.microservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }
}
