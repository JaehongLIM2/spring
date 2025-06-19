package com.example.spring.controller;

import com.example.spring.dto.Entity36Dto;
import com.example.spring.dto.Entity39Dto;
import com.example.spring.dto.ProductInfo;
import com.example.spring.dto.ProuctInfo2;
import com.example.spring.entity.Entity34;
import com.example.spring.entity.Entity36;
import com.example.spring.service.Service8;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("main26")
@RequiredArgsConstructor
public class Controller26 {

    private final Service8 service8;

    @GetMapping("sub1")
    public String sub1() {
        service8.action1();
        return "main26/sub1";
    }

    @GetMapping("sub2")
    public String sub2() {
        service8.action2();
        return "main26/sub2";
    }


    @RequestMapping("sub3")
    public String sub3() {
        service8.action3();
        return "main26/sub3";
    }

    @RequestMapping("sub4")
    public String sub4() {
        service8.action4();
        return "main26/sub4";
    }

    @RequestMapping("sub5")
    public String sub5() {
        service8.action5();
        return "main26/sub5";
    }

    @RequestMapping("sub6")
    public String sub6() {
        service8.action6();
        return "main26/sub6";
    }

    @RequestMapping("sub7")
    public String sub7() {
        service8.action7();
        return "main26/sub7";
    }

    @RequestMapping("sub8")
    public String sub8() {
        Entity36 l1 = service8.action8();

        System.out.println(l1.getRegisteredAt());

        Entity34 s1 = l1.getStudent();
        // LAZY 일 경우 이 때 SELECT 쿼리 실행
        // session 이 닫혀서 exception 이 발생
        String name = s1.getName();
        System.out.println("name = " + name);

        return "main26/sub8";
    }

    @RequestMapping("sub9")
    public String sub9() {
        Entity36Dto l1 = service8.action9();

        System.out.println(l1.getRegisteredAt());
        System.out.println("l1.getStudentName() = " + l1.getStudentName());


        return "main26/sub9";
    }

    @RequestMapping("sub10")
    public String sub10() {
        List<Entity39Dto> result = service8.action10();

        return "main26/sub10";
    }

    @RequestMapping("sub11")
    public String sub11() {
        List<ProductInfo> result = service8.action11();

        for (ProductInfo productInfo : result) {
            System.out.println(productInfo.getId());
            System.out.println(productInfo.getProductName());
            System.out.println(productInfo.getPrice());
            System.out.println(productInfo.getCategoryName());
            System.out.println();
        }
        return "main26/sub11";
    }

    @RequestMapping("sub12")
    public String sub12() {
        List<ProuctInfo2> result = service8.action12();
        for (ProuctInfo2 prouctInfo2 : result) {
            System.out.println(prouctInfo2.getOrderDate());
            System.out.println(prouctInfo2.getProductName());
            System.out.println(prouctInfo2.getPrice());
            System.out.println(prouctInfo2.getQuantity());
            System.out.println(prouctInfo2.getCategoryName());
            System.out.println();
        }
        return "main26/sub12";
    }
}
