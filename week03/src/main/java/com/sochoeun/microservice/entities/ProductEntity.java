package com.sochoeun.microservice.entities;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {
    private int id;
    private String title;
    private String description;
    private Double price;
    private Double discount;
    private LocalDateTime createdDate;
    private boolean deleted;
}
