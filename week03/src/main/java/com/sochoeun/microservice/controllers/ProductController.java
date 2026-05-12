package com.sochoeun.microservice.controllers;

import com.sochoeun.microservice.dto.request.ProductRequest;
import com.sochoeun.microservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(
                productService.getAllProducts(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable Integer productId) {
        return new ResponseEntity<>(
                productService.getProduct(productId),
                HttpStatus.OK
        );
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest request) {
        return new ResponseEntity<>(
                productService.createProduct(request),
                HttpStatus.CREATED
        );
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateProduct(
            @RequestParam Integer productId,
            @RequestBody ProductRequest request) {
        return new ResponseEntity<>(
                productService.updateProduct(productId, request),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProduct(@RequestParam Integer productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(
                HttpStatus.NO_CONTENT
        );
    }
}
