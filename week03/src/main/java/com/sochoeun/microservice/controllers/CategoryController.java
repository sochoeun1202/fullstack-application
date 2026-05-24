package com.sochoeun.microservice.controllers;

import com.sochoeun.microservice.dto.request.CategoryRequest;
import com.sochoeun.microservice.dto.response.CategoryResponse;
import com.sochoeun.microservice.exception.MessageResponse;
import com.sochoeun.microservice.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<MessageResponse<List<CategoryResponse>>> getAllCategories() {
        return new ResponseEntity<>(
                new MessageResponse<>(
                        categoryService.getAllCategories(),
                        true,
                        "Get all categories successfully",
                        "200"
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<MessageResponse<CategoryResponse>> getCategory(@PathVariable Integer categoryId) {
        return new ResponseEntity<>(
                new MessageResponse<>(
                        categoryService.getCategory(categoryId),
                        true,
                        "Get category successfully",
                        "200"
                ),
                HttpStatus.OK
        );
    }

    @PostMapping("/create")
    public ResponseEntity<MessageResponse<CategoryResponse>> createCategory(@RequestBody CategoryRequest request) {
        return new ResponseEntity<>(
                new MessageResponse<>(
                        categoryService.createCategory(request),
                        true,
                        "Create category successfully",
                        "200"
                ),
                HttpStatus.OK
        );
    }

    @PatchMapping("/update")
    public ResponseEntity<MessageResponse<CategoryResponse>> updateCategory(
            @RequestParam Integer categoryId,
            @RequestBody CategoryRequest request) {
        return new ResponseEntity<>(
                new MessageResponse<>(
                        categoryService.updateCategory(categoryId, request),
                        true,
                        "Update category successfully",
                        "200"
                ),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCategory(@RequestParam Integer categoryId) {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(
                new MessageResponse<>(
                        null,
                        true,
                        "Delete category successfully",
                        "200"
                ),
                HttpStatus.OK
        );
    }
}
