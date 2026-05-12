package com.sochoeun.microservice.services;

import com.sochoeun.microservice.dto.request.ProductRequest;
import com.sochoeun.microservice.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {

    List<ProductResponse> getAllProducts();
    ProductResponse getProduct(Integer productId);
    ProductResponse createProduct(ProductRequest request);
    ProductResponse updateProduct(Integer productId,ProductRequest request);
    void deleteProduct(Integer productId);
}
