package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "my_table4")
@Data
public class Entity4 {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double score;
    private LocalDate birthDate;
    private LocalTime startAt;
    private LocalDateTime createAt;



}
