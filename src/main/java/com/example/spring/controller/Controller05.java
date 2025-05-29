package com.example.spring.controller;

import com.example.spring.dto.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main5")
public class Controller05 {
    @RequestMapping("sub1")
    public String sub1(Model model) {

        model.addAttribute("name", "son");

        // attribute 가 javaBeans(dto)
        MyBean051 m = new MyBean051();
        model.addAttribute("obj", m);
        m.setAge(20);
        m.setAddress("seoul");
        m.setName("hong");

        // forward to /templates/main5/sub1.html
        return "main5/sub1";
    }

    // 연습 : 아래 코드를 보고 나머지 코드들(dto, html)을 완성하세요.

    @RequestMapping("sub2")
    public String sub2(Model model) {
        MyBean052 obj = new MyBean052();
        obj.setHome("ny");
        obj.setScore(98.76);
        obj.setHeight(180.5);
        obj.setNickname("tiger");
        model.addAttribute("attr", obj);


        return "main5/sub2";
    }

    @RequestMapping("sub3")
    public String sub3(Model model) {
        MyBean053 obj = new MyBean053();
        obj.setWeight(75.2);
        obj.setInfo("hello");
        obj.setStudentNumber(103);
        obj.setMarried(true);
        model.addAttribute("val", obj);

        return "main5/sub3";
    }

    // model attribute type 이 Map
    @RequestMapping("sub4")
    public String sub4(Model model) {
        model.addAttribute("riri",
                Map.of("name", "tiger",
                        "age", 20,
                        "address", "seoul",
                        "my info", "my name is HongJae"
                ));

        return "main5/sub4";
    }

    @RequestMapping("sub5")
    public String sub5(Model model) {
        model.addAttribute("value", Map.of(
                "home", "제주",
                "address", "세화",
                "birth date", "2010-08-17",
                "score", 98.76
        ));

        return "main5/sub5";
    }

    @RequestMapping("sub6")
    public String sub6(Model model) {
        model.addAttribute("car", Map.of(
                "model", "sonata",
                "company", "hyundai",
                "price", "30,000,000",
                "used", false,
                "pre user", "hongjae"
        ));
        return "main5/sub6";
    }

    @RequestMapping("sub7")
    public String sub7(Model model) {
        model.addAttribute("list", new String[]{"java","css","react","vue"});
        return "main5/sub7";
    }

    @RequestMapping("sub8")
    public String sub8(Model model) {
        model.addAttribute("skills", new String[]{"bootstrap","thymeleaf","react"});
        return "main5/sub8";
    }

    // 연습 : 리스트의 원소들을 출력하는 html 완성
    @RequestMapping("sub9")
    public String sub9(Model model) {
        model.addAttribute("cars", List.of("tesla","bmw", "volvo", "waymo"));

        return "main5/sub9";
    }

    @RequestMapping("sub10")
    public String sub10(Model model) {
        MyBean0054 o = new MyBean0054("hong", 29, List.of("1234", "5678", "2938"));

        model.addAttribute("my", o);


        return "main5/sub10";
    }

    @RequestMapping("sub11")
    public String sub11(Model model) {
        MyBean0511 person = new MyBean0511(
                17231,
                List.of("jeju", "seoul"),
                List.of("hyundai", "samsung"));

        model.addAttribute("person", person);
        return "main5/sub11";
    }

    @RequestMapping("sub12")
    public String sub12(Model model) {
        model.addAttribute("people", List.of(
                new MyBean0512("tesla", 20, false),
                new MyBean0512("hyundai", 312, true),
                new MyBean0512("apple", 209, true)));

        return "main5/sub12";
    }

    @RequestMapping("sub13")
    public String sub13(Model model) {

        model.addAttribute("aiList",
                List.of(new MyBean0513("gemini", "2020-01-01", 3000),
                        new MyBean0513("chatGPT", "1919-12-12", 2500),
                        new MyBean0513("copilot", "1988-11-11", 6500)));
        return "main5/sub13";
    }

}
