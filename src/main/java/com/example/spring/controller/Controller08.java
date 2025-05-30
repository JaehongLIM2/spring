package com.example.spring.controller;


import com.example.spring.dto.MyBean0513;
import com.example.spring.dto.MyBean053;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("main8")
public class Controller08 {


    @RequestMapping("sub1")
    public String sub1(Model model) {
        model.addAttribute("students",
                List.of(new MyBean053(10, 33.3, "trin", true),
                        new MyBean053(20, 44.4, "elo", false),
                        new MyBean053(30, 55.5, "son", true),
                        new MyBean053(40, 66.6, "john", false),
                        new MyBean053(50, 77.7, "hong", true)));


        return "main8/sub1";
    }

    @RequestMapping("sub2")
    public String sub2(Model model) {

        model.addAttribute("myList", List.of(
                new MyBean0513("lee", "01-01", 5000),
                new MyBean0513("son", "02-02", 6000),
                new MyBean0513("lim", "03-03", 7000),
                new MyBean0513("park", "04-04", 3000),
                new MyBean0513("choi", "05-05", 8000)));

        return "main8/sub2";
    }

    @RequestMapping("sub3")
    public String sub3(Model model, HttpSession session) {


        return "main8/sub3";
    }

    @RequestMapping("sub4")
    public String sub4(Model model, String animal) {

        model.addAttribute("animal", animal);

        return "main8/sub4";
    }

    @RequestMapping("sub5")
    public String sub5(Model model) {

        return "main8/sub5";
    }

    @RequestMapping("sub6")
    public String sub6(Model model) {

        return "main8/sub6";
    }

}
