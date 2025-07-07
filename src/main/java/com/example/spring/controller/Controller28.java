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
}
