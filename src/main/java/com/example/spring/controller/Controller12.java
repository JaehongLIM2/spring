package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("main12")
public class Controller12 {

    @GetMapping("sub1")
    public String sub1(Model model) {

        model.addAttribute("address", "seoul");

        // view 로 forward
        return "main12/sub1";
    }

    @GetMapping("sub2")
    public String sub2(Model model,
                       // redirect 시나리오에서 model 에 값을 전달해주는 역할
                       RedirectAttributes rttr) {


        System.out.println("Controller12.sub2");

        model.addAttribute("country", "korea");
        rttr.addFlashAttribute("city", "seoul");


        // redirection : 다른 곳으로 요청하라는 응답
        return "redirect:/main12/sub3";
    }

    @GetMapping("sub3")
    public String sub3(Model model) {

        System.out.println("Controller12.sub3");
        model.addAttribute("email", "yahoo");

        return "main12/sub3";
    }

    // 연습
    // get /main12/sub4
    //    : /main12/sub5 로 redirection
    //      RedirectAttributes 에 name : donald를 넣고

    // get /main12/sub5 에서
    //    : /main12/sub5.html 로 forward
    //  view 에서 name Model attribute 꺼내서 출력하기

    @GetMapping("sub4")
    public String sub4(RedirectAttributes rttr) {

        rttr.addFlashAttribute("name", "donald");


        return "redirect:/main12/sub5";
    }

    @GetMapping("sub5")
    public String sub5(Model model) {

        return "main12/sub5";
    }


}
