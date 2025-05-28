package com.example.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class Controller02 {

    // /main2/sub1?name
    @RequestMapping(value = "/main2/sub1", params = "name")
    public void sub1(WebRequest request) {
        // header 정보
        request.getHeader("User-Agent");


        System.out.println("Controller02.sub1");
    }

    // /main2/sub1?name&address
    // ? : query string
    // query string : name1=value&name2=value2
    @RequestMapping(value = "/main2/sub2", params = {"name", "address"})
    public void sub2(WebRequest request) {
        // header 정보
        request.getHeader("User-Agent");


        System.out.println("Controller02.sub2");
    }
}

