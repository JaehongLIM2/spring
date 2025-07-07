package com.example.spring.controller;

import com.example.spring.dto.MyBean291;
import com.example.spring.dto.MyBean292;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/main29")
@ResponseBody
public class Controller29 {

    @PostMapping("sub1")
    public String sub1() {
        System.out.println("Controller29 sub1");
        return null;
    }

    @PostMapping("sub2")
    public String sub2() {
        System.out.println("Controller29 sub2");
        return null;
    }

    @PostMapping("sub3")
    public String sub3() {
        System.out.println("Controller29 sub3");
        return null;
    }

    @PostMapping("sub4")
    public String sub4(@RequestBody Map<String, Object> map) {
        // @RequestBody : JSON 을 해당 타입(Map)으로 역직렬화(디코딩, 파싱) 해주는 어노테이션
        System.out.println("Controller29 sub4");
        System.out.println("map = " + map);
        return null;
    }

    @PostMapping("sub5")
    public String sub5(@RequestBody Map<String, Object> map) {
        System.out.println("Controller29 sub5");
        System.out.println("map = " + map);
        // {address=seoul, score=88.12, country=korea}
        return null;
    }

    @PostMapping("sub6")
    public String sub6(@RequestBody Map<String, Object> map) {
        System.out.println("Controller29 sub6");
        System.out.println("map = " + map);
        Object val1 = map.get("val1"); // string
        Object val2 = map.get("val2"); // number
        Object val3 = map.get("val3"); // number
        Object val4 = map.get("val4"); // boolean
        Object val5 = map.get("val5"); // boolean
        Object val6 = map.get("val6"); // null
        System.out.println("val1.getClass().getSimpleName() = " + val1.getClass().getSimpleName());
        System.out.println("val2.getClass().getSimpleName() = " + val2.getClass().getSimpleName());
        System.out.println("val3.getClass().getSimpleName() = " + val3.getClass().getSimpleName());
        System.out.println("val4.getClass().getSimpleName() = " + val4.getClass().getSimpleName());
        System.out.println("val5.getClass().getSimpleName() = " + val5.getClass().getSimpleName());
        System.out.println("val6 = " + val6);
        return null;
    }

    @PostMapping("sub7")
    public String sub7(@RequestBody Map<String, Object> map) {
        Object address = map.get("address");
        Object score = map.get("score");
        Object age = map.get("age");
        Object married = map.get("married");

        System.out.println(address.getClass().getSimpleName());
        System.out.println(score.getClass().getSimpleName());
        System.out.println(age.getClass().getSimpleName());
        System.out.println(married.getClass().getSimpleName());
        return null;
    }

    @PostMapping("sub8")
    public String sub8(@RequestBody Map<String, Object> map) {
        Object address = map.get("address");
        Object age = map.get("age");
        Object fruits = map.get("fruits");

        // JSON 의 array 타입은 JAVA의 ArrayList 로 파싱됨
        System.out.println(fruits.getClass().getSimpleName()); // ArrayList
        System.out.println("fruits = " + fruits);
        return null;
    }

    @PostMapping("sub9")
    public String sub9(@RequestBody Map<String, Object> map) {
        Object name = map.get("name");
        Object teams = map.get("teams");
        Object person = map.get("person");

        // JSON 의 object 타입은 JAVA의 HashMap 으로 파싱됨
        System.out.println(person.getClass().getSimpleName());
        System.out.println("person = " + person);
        return null;
    }

    @PostMapping("sub10")
    public String sub10(@RequestBody Map<String, Object> map) {
        Object cityList = map.get("cityList");
        Object team = map.get("team");

        System.out.println(cityList.getClass().getSimpleName());
        System.out.println(team.getClass().getSimpleName());

        System.out.println("cityList = " + cityList);
        System.out.println("team = " + team);
        return null;
    }

    @PostMapping("sub11")
    public String sub11(@RequestBody List<Object> data) {
        System.out.println("data = " + data);
        return null;
    }

    @PostMapping("sub12")
    public String sub12(@RequestBody List<Map<String, Object>> data) {
        System.out.println("data = " + data);
        for (Map<String, Object> map : data) {
            System.out.println(map);
        }
        return null;
    }

    @PostMapping("sub13")
    public String sub13(@RequestBody MyBean291 dto) {
        System.out.println(dto.getNickName());
        System.out.println(dto.getAge());
        System.out.println(dto.getMarried());
        System.out.println(dto.getTeam());
        System.out.println(dto.getAddress());
        return null;
    }

    @PostMapping("sub14")
    public String sub14(@RequestBody MyBean292 dto) {
        System.out.println("dto.getPerson() = " + dto.getPerson());
        System.out.println("dto.getCity() = " + dto.getCity());
        System.out.println("dto.getScore() = " + dto.getScore());
        System.out.println("dto.getChecked() = " + dto.getChecked());
        System.out.println("dto.getFruits() = " + dto.getFruits());
        return null;

    }

}
