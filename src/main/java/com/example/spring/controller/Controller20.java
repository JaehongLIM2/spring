package com.example.spring.controller;


import com.example.spring.service.Service2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main20")
@RequiredArgsConstructor
public class Controller20 {

    private final Service2 service2;

    @GetMapping("sub1")
    public String sub1(Model model) {

        service2.sayHello();

        model.addAttribute("msg", "Hello World");


        return "main20/sub1";
    }

    @GetMapping("sub2")
    public String sub2(Model model) {
        service2.process2();

        return "main20/sub2";
    }

}
