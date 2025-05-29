package com.example.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MyBean0511 {
    private Integer number;
    private List<String> address;
    private List<String> company;
}
