package com.sochoeun.microservice.repositories;

import com.sochoeun.microservice.dto.request.ProductRequest;
import com.sochoeun.microservice.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findAll();
    Optional<ProductEntity> findById(Integer productId);
    ProductEntity save(ProductEntity request);
    void deleteById(Integer productId);
}
