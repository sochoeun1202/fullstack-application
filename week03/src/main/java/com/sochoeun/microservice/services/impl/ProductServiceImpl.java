package com.sochoeun.microservice.services.impl;

import com.sochoeun.microservice.dto.request.ProductRequest;
import com.sochoeun.microservice.dto.response.ProductResponse;
import com.sochoeun.microservice.entities.ProductEntity;
import com.sochoeun.microservice.exception.ApiException;
import com.sochoeun.microservice.mappers.ProductMapper;
import com.sochoeun.microservice.repositories.ProductRepository;
import com.sochoeun.microservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductResponse> getAllProducts() {
        // TODO: create array list ProductResponse
        List<ProductResponse> responseList = new ArrayList<>();

        // TODO: get list product from repository
        List<ProductEntity> productList = productRepository.findAll();

        // TODO: map productList to responseList by adding each product to responseList
        productList.forEach((product) -> {
            ProductResponse response = productMapper.toResponse(product);
            responseList.add(response);
        });

        return responseList;
    }

    @Override
    public ProductResponse getProduct(Integer productId) {
        // TODO: product return Optional, so we need to check if product is present or not
        ProductEntity product = productRepository.findById(productId).orElseThrow(() -> new ApiException("Product not found", "404"));

        // TODO: map product to productResponse
        return productMapper.toResponse(product);
    }

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        // TODO: map request to entity
        ProductEntity getProduct = productMapper.toEntity(request);

        // TODO: map entity to response and return that result
        return productMapper.toResponse(productRepository.save(getProduct));
    }

    @Override
    public ProductResponse updateProduct(Integer productId, ProductRequest request) {
        // TODO: find product by id, if not found throw exception
        ProductEntity product = productRepository.findById(productId).orElseThrow(() -> new ApiException("Product not found", "404"));

        // TODO: update product
        product.setTitle(request.getTitle());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setDiscount(request.getDiscount());

        // TODO: save product & return
        return productMapper.toResponse(productRepository.save(product));
    }

    @Override
    public void deleteProduct(Integer productId) {
        // TODO: find product by id
        productRepository.findById(productId).orElseThrow(() -> new ApiException("Product not found", "404"));

        // TODO: delete product by id
        productRepository.deleteById(productId);
    }
}
