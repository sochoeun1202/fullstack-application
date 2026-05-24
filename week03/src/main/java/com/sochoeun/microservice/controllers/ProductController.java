package com.sochoeun.microservice.controllers;

import com.sochoeun.microservice.dto.request.ProductRequest;
import com.sochoeun.microservice.dto.response.ProductResponse;
import com.sochoeun.microservice.exception.MessageResponse;
import com.sochoeun.microservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<MessageResponse<List<ProductResponse>>> getAllProducts() {
        return new ResponseEntity<>(
                new MessageResponse<>(
                        productService.getAllProducts(),
                        true,
                        "Get all products successfully",
                        "200"
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/{productId}")
    public ResponseEntity<MessageResponse<ProductResponse>> getProduct(@PathVariable Integer productId) {
        return new ResponseEntity<>(
                new MessageResponse<>(
                        productService.getProduct(productId),
                        true,
                        "Get product successfully",
                        "200"
                ),
                HttpStatus.OK
        );
    }

    @PostMapping("/create")
    public ResponseEntity<MessageResponse<ProductResponse>> createProduct(@RequestBody ProductRequest request) {
        return new ResponseEntity<>(
                new MessageResponse<>(
                        productService.createProduct(request),
                        true,
                        "Create product successfully",
                        "200"
                ),
                HttpStatus.OK
        );
    }

    @PatchMapping("/update")
    public ResponseEntity<MessageResponse<ProductResponse>> updateProduct(
            @RequestParam Integer productId,
            @RequestBody ProductRequest request) {
        return new ResponseEntity<>(
                new MessageResponse<>(
                        productService.updateProduct(productId, request),
                        true,
                        "Update product successfully",
                        "200"
                ),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProduct(@RequestParam Integer productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(
                new MessageResponse<>(
                        null,
                        true,
                        "Delete product successfully",
                        "200"
                ),
                HttpStatus.OK
        );
    }
}
