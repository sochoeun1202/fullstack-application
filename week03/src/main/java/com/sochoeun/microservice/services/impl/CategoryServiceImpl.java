package com.sochoeun.microservice.services.impl;

import com.sochoeun.microservice.dto.request.CategoryRequest;
import com.sochoeun.microservice.dto.response.CategoryResponse;
import com.sochoeun.microservice.entities.CategoryEntity;
import com.sochoeun.microservice.exception.ApiException;
import com.sochoeun.microservice.mappers.CategoryMapper;
import com.sochoeun.microservice.repositories.CategoryRepository;
import com.sochoeun.microservice.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponse getCategory(Integer categoryId) {
        CategoryEntity category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ApiException("Category not found", "404"));
        return categoryMapper.toResponse(category);
    }

    @Override
    public CategoryResponse createCategory(CategoryRequest request) {
        CategoryEntity category = categoryMapper.toEntity(request);
        return categoryMapper.toResponse(categoryRepository.save(category));
    }

    @Override
    public CategoryResponse updateCategory(Integer categoryId, CategoryRequest request) {
        CategoryEntity category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ApiException("Category not found", "404"));
        category.setName(request.getName());
        return categoryMapper.toResponse(categoryRepository.save(category));
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        if (!categoryRepository.existsById(categoryId)) {
            throw new ApiException("Category not found", "404");
        }
        categoryRepository.deleteById(categoryId);
    }
}
