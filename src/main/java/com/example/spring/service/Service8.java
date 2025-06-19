package com.example.spring.service;

import com.example.spring.dto.Entity36Dto;
import com.example.spring.dto.Entity39Dto;
import com.example.spring.dto.ProductInfo;
import com.example.spring.dto.ProuctInfo2;
import com.example.spring.entity.Entity34;
import com.example.spring.entity.Entity35;
import com.example.spring.entity.Entity36;
import com.example.spring.entity.Entity39;
import com.example.spring.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class Service8 {


    private final Entity35Repository entity35Repository;
    private final Entity34Repository entity34Repository;
    private final Entity36Repository entity36Repository;
    private final Entity39Repository entity39Repository;
    private final Entity41Repository entity41Repository;

    public void action1() {
        // 학생 정보 입력
        Entity34 s1 = new Entity34();
        Entity34 s2 = new Entity34();
        Entity34 s3 = new Entity34();
        s1.setName("lee");
        s2.setName("wang");
        s3.setName("zhang");
        entity34Repository.save(s1);
        entity34Repository.save(s2);
        entity34Repository.save(s3);

        // 강의 정보 입력
        Entity35 c1 = new Entity35();
        Entity35 c2 = new Entity35();
        Entity35 c3 = new Entity35();
        c1.setLectureTitle("Java");
        c2.setLectureTitle("Spring");
        c3.setLectureTitle("Hibernate");
        entity35Repository.save(c1);
        entity35Repository.save(c2);
        entity35Repository.save(c3);

        // 수강 정보 입력
        Entity36 e1 = new Entity36();
        Entity36 e2 = new Entity36();
        Entity36 e3 = new Entity36();
        Entity36 e4 = new Entity36();
        Entity36 e5 = new Entity36();
        Entity36 e6 = new Entity36();
        e1.setRegisteredAt(LocalDate.now());
        e2.setRegisteredAt(LocalDate.now());
        e3.setRegisteredAt(LocalDate.now());
        e4.setRegisteredAt(LocalDate.now());
        e5.setRegisteredAt(LocalDate.now());
        e6.setRegisteredAt(LocalDate.now());

        // 학생1 -> 강의 1, 2
        e1.setStudent(s1);
        e2.setStudent(s1);
        e1.setLecture(c1);
        e2.setLecture(c2);
        // 학생2 -> 강의 2, 3
        e3.setStudent(s2);
        e4.setStudent(s2);
        e3.setLecture(c2);
        e4.setLecture(c3);
        // 학생3 -> 강의 1, 3
        e5.setStudent(s3);
        e6.setStudent(s3);
        e5.setLecture(c1);
        e6.setLecture(c3);

        entity36Repository.save(e1);
        entity36Repository.save(e2);
        entity36Repository.save(e3);
        entity36Repository.save(e4);
        entity36Repository.save(e5);
        entity36Repository.save(e6);
    }

    public void action2() {
        Entity34 s1 = new Entity34();
        Entity34 s2 = new Entity34();
        s1.setName("lim");
        s2.setName("yoshitake");
        entity34Repository.save(s1);
        entity34Repository.save(s2);

        Entity35 c1 = new Entity35();
        Entity35 c2 = new Entity35();
        c1.setLectureTitle("C++");
        c2.setLectureTitle("Python");
        entity35Repository.save(c1);
        entity35Repository.save(c2);

        Entity36 e1 = new Entity36();
        Entity36 e2 = new Entity36();
        Entity36 e3 = new Entity36();
        Entity36 e4 = new Entity36();
        e1.setRegisteredAt(LocalDate.now());
        e2.setRegisteredAt(LocalDate.now());
        e3.setRegisteredAt(LocalDate.now());
        e4.setRegisteredAt(LocalDate.now());
        e1.setStudent(s1);
        e2.setStudent(s1);
        e1.setLecture(c1);
        e2.setLecture(c2);
        e3.setStudent(s2);
        e4.setStudent(s2);
        e3.setLecture(c1);
        e4.setLecture(c2);
        entity36Repository.save(e1);
        entity36Repository.save(e2);
        entity36Repository.save(e3);
        entity36Repository.save(e4);
    }

    public void action3() {
        // 4번학생이 수강한 강의 지우기
        entity36Repository.deleteByStudentId(4);
    }

    public void action4() {
        // 5번학생 지우기
        entity34Repository.deleteById(5);
    }

    public void action5() {
        // 5번학생의 수강정보를 먼저 지워야함
        entity36Repository.deleteByStudentId(5);
        // 5번학생 지우기
        entity34Repository.deleteById(5);
    }

    public void action6() {
        // 연습
        // 3번 강의 지우기
        entity36Repository.deleteByLectureId(3);
        entity35Repository.deleteById(3);
    }

    public void action7() {

    }

    public Entity36 action8() {
        Entity36 l1 = entity36Repository.findById(1).get();

        return l1;


    }

    public Entity36Dto action9() {
        Entity36 l1 = entity36Repository.findById(1).get();

        Entity36Dto d1 = new Entity36Dto();
        d1.setRegisteredAt(l1.getRegisteredAt());
        d1.setStudentName(l1.getStudent().getName());
        // Entity 를 리턴하면 안됨
        // -> DTO 로 값 옮겨 담기 리턴하기
        return d1;
    }

    public List<Entity39Dto> action10() {
        // t39(product), t40(category)
        // 상품 번호, 상품명, 가격, 카테고리명
        List<Entity39> list = entity39Repository.findAll();
        List<Entity39Dto> result = new ArrayList<>();
        for (Entity39 entity39 : list) {
            Entity39Dto d = new Entity39Dto();
            d.setId(entity39.getId());
            d.setName(entity39.getName());
            d.setPrice(entity39.getPrice());
            d.setCategoryName(entity39.getCategory().getName());
            result.add(d);
        }

        return result;
    }

    public List<ProductInfo> action11() {
        // t39(product), t40(category)
        // 상품 번호, 상품명, 가격, 카테고리명
        /*
        SELECT p.id, p.name product_name, p.price, c.name category_name
        FROM my_table39 p
        JOIN my_table40 c on p.category_id = c.id;
         */
        List<ProductInfo> result = entity39Repository.query1();
        return result;
    }

    public List<ProuctInfo2> action12() {
        List<ProuctInfo2> prouctInfo2s = entity41Repository.query1();

        return prouctInfo2s;

    }
}
