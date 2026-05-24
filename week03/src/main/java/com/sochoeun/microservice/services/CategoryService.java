package com.sochoeun.microservice.services;

import com.sochoeun.microservice.dto.request.CategoryRequest;
import com.sochoeun.microservice.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategories();
    CategoryResponse getCategory(Integer categoryId);
    CategoryResponse createCategory(CategoryRequest request);
    CategoryResponse updateCategory(Integer categoryId, CategoryRequest request);
    void deleteCategory(Integer categoryId);
}
