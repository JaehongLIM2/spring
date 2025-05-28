package com.example.spring.controller;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;


@RestController
public class Controller02 {

    // /main2/sub1?name
    @RequestMapping(value = "/main2/sub1", params = "name")
    public void sub1(WebRequest request) {
        // header 정보
        request.getHeader("User-Agent");


        System.out.println("Controller02.sub1");
    }

    // /main2/sub1?name&address
    // ? : query string
    // query string : name1=value&name2=value2
    @RequestMapping(value = "/main2/sub2", params = {"name", "address"})
    public void sub2(WebRequest request) {
        // header 정보
        request.getHeader("User-Agent");


        System.out.println("Controller02.sub2");
    }

    // /main2/sub3?name
    @RequestMapping(value = "/main2/sub3", params = "name")
    public void sub3(WebRequest request) {
        String name = request.getParameter("name");
        System.out.println("name = " + name);
        System.out.println("Controller02.sub3");
    }

    // /main2/sub3?address
    @RequestMapping(value = "/main2/sub3", params = "address")
    public void sub4(WebRequest request) {
        String address = request.getParameter("address");
        System.out.println("address = " + address);
        System.out.println("Controller02.sub4");
    }

    // @RequestParam : 해당 이름의 request parameter 를 method parameter 에 binding 해줌

    // /main2/sub5?email=gmail
    @RequestMapping(value = "/main2/sub5", params = "email")
    public void sub5(@RequestParam("email") String str) {
        System.out.println("str = " + str);

    }


    // /main2/sub6?email=gmail&age=55
    @RequestMapping(value = "/main2/sub6", params = {"email", "age"})
    public void sub6(@RequestParam("email") String str,
                     @RequestParam("age") String v) {
        System.out.println("str = " + str);
        System.out.println("v = " + v);
    }

    // /main2/sub7?email=gmail&age=55
    @RequestMapping("/main2/sub7")
    public void sub7(@RequestParam("email") String str,
                     @RequestParam("age") String v) {
        System.out.println("str = " + str);
        System.out.println("v = " + v);
    }

    // 연습 :
    // /main2/sub8?address=jeju&country=korea&city=gangnam

    @RequestMapping("/main2/sub8")
    public void sub8(@RequestParam("address") String address,
                     @RequestParam("country") String country,
                     @RequestParam("city") String city) {
        System.out.println("address = " + address);
        System.out.println("country = " + country);
        System.out.println("city = " + city);
    }

    // /main2/sub8?address=jeju&country=korea&city=gangnam
    @RequestMapping("/main2/sub9")
    public void sub9(@RequestParam("city") String city,
                     @RequestParam("age") String age) {
        System.out.println("city = " + city);
        System.out.println("age = " + age);
        int i = Integer.parseInt(age);
        System.out.println("i = " + i);
    }

    // /main2/sub10?city=seoul&age=67
    @RequestMapping("/main2/sub10")
    public void sub10(@RequestParam("city") String city,
                      @RequestParam("age") int age) {
        System.out.println("city = " + city);
        System.out.println("age = " + age);
    }

    // request parameter 의 이름이 method parameter와 같으면
    // @RequestParam 의 value 속성을 생략해도 됨
    // /main2/sub11?city=seoul&age=67
    @RequestMapping("/main2/sub11")
    public void sub11(@RequestParam String city,
                      @RequestParam int age) {
        System.out.println("city = " + city);
        System.out.println("age = " + age);
    }

    // request parameter 의 이름이 method parameter와 같으면
    // @RequestParam 의 value 속성을 생략해도 됨
    // @RequestParam 을 생략해도됨
    // /main2/sub11?city=seoul&age=67
    @RequestMapping("/main2/sub12")
    public void sub12(String city, int age) {
        System.out.println("city = " + city);
        System.out.println("age = " + age);
    }

    // 연습
    // /main2/sub13?email=gmail&score=88.8&married=true
    @RequestMapping("/main2/sub13")
    public void sub13(String email, double score, boolean married) {
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    // /main2/sub14?email=gmail&score=88.8&married=true
    @RequestMapping("/main2/sub14")
    public void sub14(@RequestParam String email, double score, boolean married) {
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    // /main2/sub15?score=88.8&married=true
    @RequestMapping("/main2/sub15") // required 값은 default 값 true, true 일 경우 값을 주지 않으면 실행이 안됨
    public void sub15(@RequestParam(required = false) String email,
                      @RequestParam(required = false) Double score, boolean married) {
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    // /main2/sub16?
    // defaultValue : 값이 존재하지 않을 때 기본 값을 줄 수 있음
    @RequestMapping("/main2/sub16") // required 값은 default 값 true, true 일 경우 값을 주지 않으면 실행이 안됨
    public void sub16(@RequestParam(required = false, defaultValue = "none") String email,
                      @RequestParam(required = false, defaultValue = "0.0") Double score,
                      @RequestParam(required = false, defaultValue = "false") Boolean married) {
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    // defaultValue : 값이 존재하지 않을 때 기본 값을 줄 수 있음
    // -> required 는 false 로 세팅됨
    @RequestMapping("/main2/sub17") // required 값은 default 값 true, true 일 경우 값을 주지 않으면 실행이 안됨
    public void sub17(@RequestParam(defaultValue = "none") String email,
                      @RequestParam(defaultValue = "0.0") Double score,
                      @RequestParam(defaultValue = "false") Boolean married) {
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    // 연습 :
    // /main2/sub18?city=seoul&home=jeju&age=33
    // /main2/sub18?home=jeju&age=33
    // /main2/sub18?city=seoul&age=33
    // /main2/sub18?city=seoul&home=jeju

    // city 기본값 ""
    // home 기본값 ""
    // age  기본값 "0"

    @RequestMapping("/main2/sub18")
    public void sub18(@RequestParam(defaultValue = "") String city,
                      @RequestParam(defaultValue = "") String home,
                      @RequestParam(defaultValue = "0") Integer age) {
        System.out.println("city = " + city);
        System.out.println("home = " + home);
        System.out.println("age = " + age);
        System.out.println("-----");
    }

    // 하나의 request parameter (요청 파라미터, 요청 변수) 가 여러 값일 때
    // main2/sub18?city=seoul&city=jeju&city=busan
    @RequestMapping("/main/sub19")
    public void method19(String[] city) {
        System.out.println(Arrays.toString(city));
    }


    @RequestMapping("/main/sub20")
    public void method20(@RequestParam(value = "city", defaultValue = "") ArrayList<String> city) {
        System.out.println("city = " + city);
    }

    // /main2/sub21?country=korea&score=90&score=80&score=70
    @RequestMapping("/main2/sub21")
    public void method21(@RequestParam(value = "country", defaultValue = "0") String country,
                         @RequestParam(value = "score", required = false) Integer[] score) {
        System.out.println("country = " + country);
        System.out.println("age = " + Arrays.toString(score));
    }

    // /main2/sub22?city=seoul&email=gmail&address=jeju&age=88&score=98&married=true
    @RequestMapping("/main2/sub22")
    public void method22(
            String city,
            String email,
            String address,
            Integer age,
            Double score,
            Boolean married) {
        System.out.println("city = " + city);
        System.out.println("email = " + email);
        System.out.println("address = " + address);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    // /main2/sub23?city=seoul&email=gmail&address=jeju&age=88&score=98&married=true
    @RequestMapping("/main2/sub23")
    public void method23(@RequestParam Map<String, Objects> param) {
        for (var entry : param.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    // /main2/sub24?city=seoul&email=gmail&address=jeju&age=88&score=98&score=87&score=32&married=true
    @RequestMapping("/main2/sub24")
    public void method24(@RequestParam MultiValueMap<String, Objects[]> param) {
        for (var entry : param.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }


}

