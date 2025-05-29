package com.example.spring.controller;

import com.example.spring.dto.MyBean051;
import com.example.spring.dto.MyBean052;
import com.example.spring.dto.MyBean053;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
