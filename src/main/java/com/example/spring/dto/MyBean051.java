package com.example.spring.dto;

import lombok.Data;

@Data
public class MyBean051 {
    private String name;
    private String address;
    private Integer age;

    // imformation : 읽기전용 property
    public String getImformation() {
        return "My name is " + name + ", My address is " + address + ", My age is " + age;
    }

}
