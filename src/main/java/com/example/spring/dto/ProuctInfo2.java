package com.example.spring.dto;

import java.time.LocalDate;

public interface ProuctInfo2 {
    LocalDate getOrderDate();
    String getProductName();
    Integer getPrice();
    Integer getQuantity();
    String getCategoryName();
}
