package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "my_table5")
@Data
public class Entity5 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String address;
    private LocalDate hiredDate;
    private LocalDateTime insertedAt;
    private Double height;
    private Integer score;
}
