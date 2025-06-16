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

    @GetMapping("sub3")
    public String sub3(Model model) {
        service2.process3();

        return "main20/sub3";
    }

    @GetMapping("sub4")
    public String sub4(Model model) {
        service2.process4();

        return "main20/sub4";
    }

    @GetMapping("sub5")
    public String sub5(Model model) {

        service2.process5();

        return "main20/sub5";
    }

    @GetMapping("sub6")
    public String sub6(Model model) {

        service2.process6();

        return "main20/sub6";
    }

    @GetMapping("sub10")
    public String sub10(Model model) {

        // Spring Data JPA
        // Entity : 테이블과 매핑되는 클래스(객체)
        // Repository : Entity 를 이용한 CRUD 메소드 제공(class, interface)
        // * SELECT : find... / get...
        // * UPDATE : save...
        // * DELETE : delete...
        // * INSERT : save...

        // JpaRepository<T, ID> 인터페이스를 상속해서 만들면 됨
        // 타입파라미터 T  : CRUD 대상 테이블의 매핑되는 Entity
        // 타입파라미터 ID : Entity의 기본키 자료형

        // Spring 은
        // Repository 인터페이스에 있는 메소드를 활용해서
        // 연결, statement, ResultSet 처리하는 구현 코드를 생성


        service2.process7();


        return "main20/sub10";
    }

    @GetMapping("sub11")
    public String sub11(Model model) {
        service2.process8();

        return "main20/sub11";
    }

    @GetMapping("sub12")
    public String sub12(Model model) {
        service2.process9();

        return "main20/sub12";
    }

    @GetMapping("sub13")
    public String sub13(Model model) {
        service2.process10();

        return "main20/sub13";
    }
}
