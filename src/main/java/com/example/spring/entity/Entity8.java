package com.example.spring.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "my_table8")
public class Entity8 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String address;

    private Double salary;

    private LocalDateTime insertedAt;

    private LocalDateTime hireDate;

    /*
    CREATE TABLE my_table8
    (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    address     VARCHAR(255),
    salary      DOUBLE,
    inserted_at datetime,
    hire_date   datetime
    );
     */



}
