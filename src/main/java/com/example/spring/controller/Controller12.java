package com.example.spring.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("sub6")
    public String sub6(RedirectAttributes rttr) {

        // 다음 요청 model 에 옮겨 담음
        rttr.addFlashAttribute("nickName", "trump");

        // query string 에 붙음
        // ?address=jeju
        rttr.addAttribute("address", "jeju");


        return "redirect:/main12/sub7";
    }

    @GetMapping("sub7")
    public String sub7(Model model) {

        return "main12/sub7";
    }

    @GetMapping("sub8")
    public String sub8(RedirectAttributes rttr) {

        rttr.addFlashAttribute("item", "car");
        rttr.addAttribute("company", "tesla");

        return "redirect:/main12/sub9";
    }

    @GetMapping("sub9")
    public String sub9(Model model) {

        return "main12/sub9";
    }

    // main
    @GetMapping("sub10")
    public String sub10(Model model) {

        return "main12/sub10";
    }

    // login page
    @GetMapping("sub11")
    public String sub11(Model model) {

        return "main12/sub11";
    }

    // login 처리
    @PostMapping("sub11")
    public String sub11Process(String id, RedirectAttributes rttr, HttpSession session) {

        session.setAttribute("userId", id);
        System.out.println(id + "로그인 처리");
        rttr.addFlashAttribute("message", id + "님이 로그인 되었습니다");
        return "redirect:/main12/sub10";
    }

    @RequestMapping("sub11/logout")
    public String sub11Logout(HttpSession session, RedirectAttributes rttr) {
        // session attribute 만 지우기
//        session.removeAttribute("userId");

        // session 객체 지우기
        session.invalidate();

        rttr.addFlashAttribute("message", "로그아웃되었습니다");

        return "redirect:/main12/sub10";
    }


    // 메인 페이지
    @GetMapping("sub12")
    public String sub12(Model model) {

        return "main12/sub12";
    }

    // 로그인 페이지
    @GetMapping("sub13")
    public String sub13(Model model) {

        return "main12/sub13";
    }

    // 로그인 처리
    @PostMapping("sub13")
    public String sub13process(String id, RedirectAttributes rttr) {

        rttr.addFlashAttribute("message", id + "님이 로그인 되었습니다.");


        return "redirect:/main12/sub12";
    }

}
