package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "my_table3")
@Getter
@Setter
@ToString
public class Entity3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "email")
    private String email;
//    @Column(name = "info")
//    클래스의 field 명과 table의 컬럼명이 같으면 @Column 생략 가능
    private String info;
//    @Column(name = "nick")
    private String nick;

    private String country;

    // java 변수명 관습 lowerCamelCase
//    private String home_address; // x
//    @Column(name = "home_address")
    private String homeAddress;

    private String workAddress;
}
