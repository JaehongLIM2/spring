package com.example.spring.controller;

import com.example.spring.dto.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("main3")
public class Controller03 {

    // http://localhost:8080/main3/sub1
    @RequestMapping("sub1")
    public void sub1() {
        System.out.println("sub1");
    }

    @RequestMapping("sub2")
    public void sub2() {
        System.out.println("sub2");
    }

    // 연습
    // main3/sub3 요청 올 때 일하는 메소드 작성
    @RequestMapping("sub3")
    public void sub3() {
        System.out.println("sub3");
    }

    // main3/sub4?param1=val1&param2=val2
    @RequestMapping("sub4")
    public void sub4(@RequestParam("param1") String param1,
                     @RequestParam("param2") String param2) {
        System.out.println("param1 = " + param1);
        System.out.println("param2 = " + param2);
    }

    // main3/sub5?address=seoul&name=hong&age=28&home=sinchon
    @RequestMapping("sub5")
    public void sub5(@RequestParam Map<String, String> param) {
        for (Map.Entry<String, String> entry : param.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    // request parameter 를 java beans(Data Transaction Object) 으로 받기
    // /main3/sub6?name=donald&address=la
    // /main3/sub6?name=trump

    @RequestMapping("sub6")
    public void sub6(MyBean031 param) {
        System.out.println("param.getName() = " + param.getName());
        System.out.println("param.getAddress() = " + param.getAddress());
    }

    // 연습 : 
    // /main3/sub7?name=musk&company=tesla&home=texas
    // MyBean032 javaBean 만들어서 request parameter 받아보기
    @RequestMapping("sub7")
    public void sub7(MyBean032 param) {
        System.out.println("param.getName() = " + param.getName());
        System.out.println("param.getCompany() = " + param.getCompany());
        System.out.println("param.getHome() = " + param.getHome());
        System.out.println("param.getAge() = " + param.getAge());
    }

    // /main3/sub8?nickName=Bob&age=55&address=seoul
    @RequestMapping("sub8")
    public void sub8(MyBean033 param) {
        System.out.println(param);
    }

    // /main3/sub9?address=seoul&salary=50.5
    @RequestMapping("sub9")
    public void sub9(MyBean035 param) {
        System.out.println(param);
    }


    // /main3/sub10?age=44&email=gmail&married=true&salary=40.4&name=donald
    // 요청 파라미터 받는 MyBean036 클래스 만들고
    // request handler method 작성
    @RequestMapping("sub10")
    public void sub10(MyBean036 param) {
        System.out.println(param);
    }
}
