package com.example.spring.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Integer productId;
    private String productName;
    private Integer supplierId;
    private Integer categoryId;
    private String unit;
    private Double price;
}
