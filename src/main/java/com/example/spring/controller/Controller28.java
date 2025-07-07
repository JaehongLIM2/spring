package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping({"/api/main28"})
@Controller
@ResponseBody
public class Controller28 {

    @GetMapping("sub1")
    public String sub1(){
        System.out.println("Controller28 sub1");
        return "null";
    }

    @PostMapping("sub2")
    public String sub2(){
        System.out.println("Controller28 sub2");
        return "null";
    }

    @GetMapping("sub4")
    public String sub4(){
        System.out.println("Controller28 sub4");
        return "null";
    }

    @PostMapping("sub5")
    public String sub5(){
        System.out.println("Controller28 sub5");
        return "null";
    }

    @GetMapping("sub6")
    public String sub6(){
        System.out.println("Controller28 sub6");
        return "null";
    }

    @GetMapping("sub7")
    public String sub7(){
        System.out.println("Controller28 sub7");
        return "null";
    }

    @GetMapping("sub8")
    public String sub8(String name, int age){
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("Controller28 sub8");
        return "null";
    }

    @GetMapping("sub9")
    public String sub9(String address, Double score) {
        System.out.println("address = " + address);
        System.out.println("score = " + score);
        System.out.println("Controller28 sub9");
        return "null";
    }

    @GetMapping("sub10")
    public String sub10(String address, Double score) {
        System.out.println("address = " + address);
        System.out.println("score = " + score);
        System.out.println("Controller28 sub10");
        return "null";
    }

    @GetMapping("sub11")
    public String sub11(String address, Double score) {
        System.out.println("address = " + address);
        System.out.println("score = " + score);
        System.out.println("Controller28 sub11");
        return "null";
    }

    @GetMapping("sub12")
    public String sub12(String fruit, Integer price) {
        System.out.println("fruit = " + fruit);
        System.out.println("price = " + price);
        System.out.println("Controller28 sub12");
        return "null";
    }

    @GetMapping("sub13")
    public String sub13(String name, Integer age, String address) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("address = " + address);
        System.out.println("Controller28 sub13");
        return "null";
    }

    @GetMapping("sub14")
    public String sub14(String city, String country, Integer id) {
        System.out.println("city = " + city);
        System.out.println("country = " + country);
        System.out.println("id = " + id);
        System.out.println("Controller28 sub14");
        return "null";
    }

    @GetMapping("sub15")
    public String sub15(String name, Integer age, String country) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("country = " + country);
        System.out.println("Controller28 sub15");
        return "null";
    }

    @GetMapping("sub16")
    public String sub16(String fruit, Integer price, String location) {
        System.out.println("fruit = " + fruit);
        System.out.println("price = " + price);
        System.out.println("location = " + location);
        System.out.println("Controller28 sub16");
        return "null";
    }
}
