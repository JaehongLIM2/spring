package com.example.spring.service;

import com.example.spring.entity.*;
import com.example.spring.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Service2 {

    private final Entity1Repository entity1Repository;
    private final Entity2Repository entity2Repository;
    private final Entity3Repository entity3Repository;
    private final Entity4Repository entity4Repository;
    private final Entity5Repository entity5Repository;
    private final Entity10Repository entity10Repository;
    private final Entity11Repository entity11Repository;
    private final Entity12Repository entity12Repository;
    private final Entity13Repository entity13Repository;
    private final Entity14Repository entity14Repository;
    private final Entity15Repository entity15Repository;


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

    public void process5() {

        Entity4 entity4 = entity4Repository.findById(1).get();
        System.out.println(entity4);
    }

    public void process6() {

        Entity5 entity5 = entity5Repository.findById(1).get();
        System.out.println(entity5);

    }

    public void process7() {
        // findById : 키(id)로 하나의 record(row)를 조회

        Optional<Entity10> data = entity10Repository.findById(1);
        System.out.println(data.isPresent());
        System.out.println(data.isEmpty());

    }

    // 연습
    // Entity11Repository.findById()를 사용해서 하나의 record 를 조회하는
    // class 작성

    public void process8() {
        Optional<Entity11> data11 = entity11Repository.findById(1);
        System.out.println(data11.isPresent());
        System.out.println(data11.isEmpty());
    }

    public void process9() {
        Optional<Entity12> data12 = entity12Repository.findById(1);
        System.out.println(data12.isPresent());
        System.out.println(data12.isEmpty());

    }

    public void process10() {

        Optional<Entity13> data13 = entity13Repository.findById(1);

        System.out.println(data13.isPresent());
        System.out.println(data13.isEmpty());
    }

    public Entity14 process11(Integer id) {
        // SELECT
        // findById(key) : key 에 해당하는 record를 저장한 Entity 객체를 리턴(Optional)

        Optional<Entity14> data = entity14Repository.findById(id);
        if (data.isPresent()) {
            return data.get();
        }
        return null;
    }

    public void process12(String name, Double score, String city) {
        // INSERT :
        // save() : 해당 entity 를 새 record 로 입력
        //        : 해당 entity 에 매핑되는 record 를 업데이트

        Entity14 data = new Entity14();
        data.setName(name);
        data.setScore(score);
        data.setCity(city);

        entity14Repository.save(data);
    }

    public void process13(String address, Integer price, LocalDateTime inserted) {
        Entity15 data = new Entity15();
        data.setAddress(address);
        data.setPrice(price);
        data.setInsertedAt(inserted);
        entity15Repository.save(data);
    }

    public void process14(Integer id, Double score) {
        // 1 . 조회하고
        Entity14 data = entity14Repository.findById(id).get();

        // 2 . 값 변경
        data.setScore(score);

        // 3 . sava
        entity14Repository.save(data);
    }

    public void process15(Integer id, String address) {
        Entity15 data = entity15Repository.findById(id).get();

        data.setAddress(address);
        entity15Repository.save(data);
    }
    public void process16(Integer id) {
        entity14Repository.deleteById(id);

    }

    public void process17(Integer id) {
        entity15Repository.deleteById(id);
    }
}
