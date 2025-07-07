package com.example.spring.controller;

import com.example.spring.dto.MyBean291;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/api/main30")
@ResponseBody
public class Controller30 {
    //    @RequestMapping(method = RequestMethod.PUT, path = "sub1")
    @PutMapping("sub1")
    public String sub1() {
        System.out.println("Controller30.sub1()");
        return null;
    }

//    @RequestMapping(method = RequestMethod.DELETE, path = "sub2")
    @DeleteMapping("sub2")
    public String sub2() {
        System.out.println("Controller30.sub2()");
        return null;
    }

    @PutMapping("sub3")
    public String sub3() {
        System.out.println("Controller30.sub3()");
        return null;
    }

    @DeleteMapping("sub4")
    public String sub4() {
        System.out.println("Controller30.sub4()");
        return null;
    }

    @PutMapping("sub5")
    public String sub5(@RequestBody MyBean291 dto) {
        System.out.println(dto);
        return null;
    }
}
