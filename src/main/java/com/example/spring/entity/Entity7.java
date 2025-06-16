package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "my_table7", schema = "jpa")
public class Entity7 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "team", length = 30)
    private String team;

    @Column(name = "city", length = 30)
    private String city;

    @Column(name = "country", length = 30)
    private String country;

    @Column(name = "height")
    private Double height;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "inserted_at")
    private LocalDateTime insertedAt;

}