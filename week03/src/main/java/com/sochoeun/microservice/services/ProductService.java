package com.sochoeun.microservice.services;

import com.sochoeun.microservice.entities.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> getAllProducts();
}
