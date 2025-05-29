package com.example.spring.dto;


import lombok.ToString;

@ToString
public class MyBean037 {
    // field : name, address, password
    // property : name, address, pw
    // *property 이름은 getter, setter 에 의해 결정됨* 중요

    private String name;
    private String address;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getpw() {
        return password;
    }

    public void setpw(String password) {
        this.password = password;
    }
}
