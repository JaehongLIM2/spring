package com.example.spring.controller;

import com.example.spring.service.Service3;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main21")
@RequiredArgsConstructor
public class Controller21 {

    private final Service3 service3;


    @GetMapping("sub1")
    public String sub1() {

        service3.action();

        return "main21/sub1";
    }

    @GetMapping("sub2")
    public String sub2() {

        service3.action2();

        return "main21/sub2";
    }

    @GetMapping("sub3")
    public String sub3() {

        service3.action3();
        return "main21/sub3";
    }
}
