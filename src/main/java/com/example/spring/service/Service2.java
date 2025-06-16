package com.example.spring.service;

import com.example.spring.entity.Entity1;
import com.example.spring.entity.Entity2;
import com.example.spring.entity.Entity3;
import com.example.spring.repository.Entity1Repository;
import com.example.spring.repository.Entity2Repository;
import com.example.spring.repository.Entity3Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Service2 {

    private final Entity1Repository entity1Repository;
    private final Entity2Repository entity2Repository;
    private final Entity3Repository entity3Repository;

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

    public void process3() {

        Entity2 entity2 = entity2Repository.findById(2).get();
        System.out.println(entity2);
    }

    // jpa 사용을 위해서
    // 1. Entity
    //      : table 과 1대 1 매칭되는 클래스
    //      : 이 클래스로 만든 각 객체는 table의 각 행과 매치됨
    //      : @Entity, @Table (클래스 - 테이블)
    //      : @Column (클래스 필드와 테이블 컬럼)
    //      : @Id (클래스 필드와 - 테이블 기본키)
    // 2. Repository

    public void process4() {
        Entity3 entity3 = entity3Repository.findById(1).get();
        System.out.println(entity3);
    }
}
