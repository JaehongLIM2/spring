package com.example.spring.controller;

import com.example.spring.service.Service1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main19")
@RequiredArgsConstructor
public class Controller19 {

    private final Service1 service1;


    @GetMapping("sub1")
    public String sub1(Model model) {
        // 1. 요청 받고 / 가공
        // 2. CRUD
        // 2 - 1. JDBC 연결
        // 2 - 2. statement
        // 2 - 3. 쿼리 실행
        // 2 -4. result set 처리
        service1.action1();

        // 3. 모델에 결고 넣고
        model.addAttribute("data", service1);
        // 4. forward

        return "main19/sub1";
    }
}
