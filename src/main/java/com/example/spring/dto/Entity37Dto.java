package com.example.spring.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.spring.entity.Entity37}
 */
@Value
public class Entity37Dto implements Serializable {
    String email;
    String info;
    LocalDateTime insertedAt;
}