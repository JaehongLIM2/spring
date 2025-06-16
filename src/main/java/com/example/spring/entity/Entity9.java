package com.example.spring.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "my_table9")
public class Entity9 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer age;

    private Integer height;

    private Integer weight;

    private String address;

    private String phone;

    private String email;
    
    private String city;

}
