package com.example.spring.controller;

import com.example.spring.dto.MyBean0511;
import com.example.spring.dto.MyBean0513;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("main7")
public class Controller07 {

    @RequestMapping("sub1")
    public String sub1(Model model) {

        model.addAttribute("aiList", List.of("gpt","gemini", "grok", "deep"));

        return "main7/sub1";
    }

    @RequestMapping("sub2")
    public String sub2(Model model) {
        /*
        |번호|이름|생일|가격|
        |1  |   |    |   |
        |2  |   |    |   |
        |3  |   |    |   |
        |4  |   |    |   |
        |5  |   |    |   |

         */
        model.addAttribute("myList", List.of(
                new MyBean0513("lee","01-01", 5000),
                new MyBean0513("son","02-02", 6000),
                new MyBean0513("lim","03-03", 7000),
                new MyBean0513("park","04-04", 3000),
                new MyBean0513("choi","05-05", 8000)));


        return "main7/sub2";
    }

    @RequestMapping("sub3")
    public String sub3(Model model) {

        model.addAttribute("myList", List.of("java", "spring", "react", "gpt", "grok"));

        return "main7/sub3";
    }

    @RequestMapping("sub4")
    public String sub4(Model model) {
        model.addAttribute("item", new MyBean0513("tri", "20-33", 2034));
        model.addAttribute("person", new MyBean0511(98, List.of("tesla", "apple"),
                List.of("seoul", "jeju")));

        return "main7/sub4";
    }

    @RequestMapping("sub5")
    public String sub5(Model model) {
        model.addAttribute("person",
                new MyBean0511(98, List.of("tesla", "apple"), List.of("seoul", "jeju")));

        return "main7/sub5";
    }

    @RequestMapping("sub6")
    public String sub6(Model model) {
        model.addAttribute("person",
                new MyBean0511(98, List.of("tesla", "apple"), List.of("seoul", "jeju")));

        return "main7/sub6";
    }

    @RequestMapping("sub7")
    public String sub7(Model model) {
        model.addAttribute("person",
                new MyBean0511(98, List.of("tesla", "apple"), List.of("seoul", "jeju")));

        return "main7/sub7";
    }
}
