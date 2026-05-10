package com.sochoeun.microservice.repositories;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.sochoeun.microservice.entities.ProductEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    private List<ProductEntity> productEntities = new ArrayList<>();

    public ProductRepository(){
        if(productEntities.isEmpty()){
            productEntities.add(
                    new ProductEntity(1,"Coca Cola","",12.90,10.0, LocalDateTime.now(), false)
            );
            productEntities.add(
                    new ProductEntity(2,"ABC","",30.90,10.0, LocalDateTime.now(), false)
            );
        }
    }
    public List<ProductEntity> findAll(){
        return productEntities;
    }
}
