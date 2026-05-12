package com.sochoeun.microservice.entities;
import java.time.LocalDateTime;

import lombok.*;
import jakarta.persistence.*;


@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private Double price;
    private Double discount;
    private LocalDateTime createdDate;
    private boolean deleted;
}
