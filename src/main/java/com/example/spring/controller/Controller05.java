package com.example.spring.controller;

import com.example.spring.dto.MyBean051;
import com.example.spring.dto.MyBean052;
import com.example.spring.dto.MyBean053;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
