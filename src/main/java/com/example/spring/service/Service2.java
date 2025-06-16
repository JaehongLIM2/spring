package com.example.spring.service;

import com.example.spring.entity.Entity1;
import com.example.spring.repository.Entity1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Service2 {

    private final Entity1Repository entity1Repository;


    public String sayHello() {
        System.out.println("Hello World");

        return "Hello World2";
    }


    public void process2() {
        // business logic

        // spring data jpa 를 사용해서 crud
        Entity1 res = entity1Repository.findById(1).get();
        System.out.println(res.getId());
        System.out.println(res.getName());
        System.out.println(res.getAddress());
        System.out.println(res.getCity());
    }


}
