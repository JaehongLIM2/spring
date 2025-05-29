package com.example.spring.controller;

import com.example.spring.dto.MyBean0512;
import com.example.spring.dto.MyBean0513;
import com.example.spring.dto.MyBean053;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("main6")
public class Controller06 {

    @RequestMapping("sub1")
    public String sub1(Model model) {

        model.addAttribute("cars", Set.of("tesla", "uber", "waymo"));
        model.addAttribute("list", List.of("java", "spring", "react"));

        return "main6/sub1";
    }

    @RequestMapping("sub2")
    public String sub2(Model model) {

        model.addAttribute("list", List.of("chatgpt", "claude", "grok", "gemini"));
        model.addAttribute("cars", Set.of("apple", "orange", "banana", "cherry"));

        return "main6/sub2";
    }

    @RequestMapping("sub3")
    public String sub3(Model model) {


        model.addAttribute("people",
                List.of(
                        new MyBean053(10, 99.5, "toil", false),
                        new MyBean053(20, 44.32, "sojo", true),
                        new MyBean053(30, 55.3, "jo", false),
                        new MyBean053(40, 23.1, "xo", true)
                ));
        return "main6/sub3";
    }

    @RequestMapping("sub4")
    public String sub4(Model model) {
        model.addAttribute("myList", List.of(
                new MyBean0513("lee","01-01", 5000),
                new MyBean0513("son","02-02", 6000),
                new MyBean0513("lim","03-03", 7000),
                new MyBean0513("park","04-04", 3000),
                new MyBean0513("choi","05-05", 8000)));


        return "main6/sub4";
    }
}