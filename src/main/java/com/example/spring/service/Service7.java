package com.example.spring.service;

import com.example.spring.entity.Entity27;
import com.example.spring.entity.Entity28;
import com.example.spring.entity.Entity29;
import com.example.spring.entity.Entity30;
import com.example.spring.repository.Entity27Repository;
import com.example.spring.repository.Entity28Repository;
import com.example.spring.repository.Entity29Repository;
import com.example.spring.repository.Entity30Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class Service7 {

    private final Entity27Repository entity27Repository;
    private final Entity28Repository entity28Repository;
    private final Entity29Repository entity29Repository;
    private final Entity30Repository entity30Repository;

    public void action1() {
        Entity27 c1 = new Entity27();
        Entity27 c2 = new Entity27();
        Entity27 c3 = new Entity27();

        c1.setCategoryName("음료수");
        c1.setInfo("설탕물");

        c2.setCategoryName("전자제품");
        c2.setInfo("전기를 사용하는 물건");

        c3.setCategoryName("청소용품");
        c3.setInfo("청소할 때 필요해");

        entity27Repository.save(c1);
        entity27Repository.save(c2);
        entity27Repository.save(c3);

    }

    public void action2() {
        Entity28 p1 = new Entity28();
        Entity28 p2 = new Entity28();
        Entity28 p3 = new Entity28();
        Entity28 p4 = new Entity28();
        Entity28 p5 = new Entity28();
        Entity28 p6 = new Entity28();

        p1.setProductName("청소기");
        p2.setProductName("컴퓨터");
        p3.setProductName("콜라");
        p4.setProductName("사이다");
        p5.setProductName("물티슈");
        p6.setProductName("모니터");

        p1.setUnit("1대");
        p2.setUnit("1대");
        p3.setUnit("1캔");
        p4.setUnit("1캔");
        p5.setUnit("1장");
        p6.setUnit("1대");

        p1.setPrice(500);
        p2.setPrice(300);
        p3.setPrice(200);
        p4.setPrice(100);
        p5.setPrice(50);
        p6.setPrice(10);

        Entity27 c1 = entity27Repository.findById(1).get();
        Entity27 c2 = entity27Repository.findById(2).get();
        Entity27 c3 = entity27Repository.findById(3).get();

        p1.setCategoryId(c3);
        p2.setCategoryId(c2);
        p3.setCategoryId(c1);
        p4.setCategoryId(c1);
        p5.setCategoryId(c3);
        p6.setCategoryId(c2);

        entity28Repository.save(p1);
        entity28Repository.save(p2);
        entity28Repository.save(p3);
        entity28Repository.save(p4);
        entity28Repository.save(p5);
        entity28Repository.save(p6);

    }

    public void action3(Integer id) {
        Entity27 entity27 = entity27Repository.findById(id).get();
        System.out.println("entity27 = " + entity27);
    }

    public void action4(Integer id) {
        Entity28 entity28 = entity28Repository.findById(id).get();
        System.out.println("entity28 = " + entity28);
    }

    public void action5(Integer id) {
        Entity29 c1 = new Entity29();
        Entity29 c2 = new Entity29();
        Entity29 c3 = new Entity29();

        c1.setFirstName("김");
        c2.setFirstName("김");
        c3.setFirstName("임");

        c1.setLastName("창범");
        c2.setLastName("두환");
        c3.setLastName("재홍");

        c1.setBirthDate(LocalDate.parse("1995-08-25"));
        c2.setBirthDate(LocalDate.parse("1995-08-15"));
        c3.setBirthDate(LocalDate.parse("1995-08-17"));

        entity29Repository.save(c1);
        entity29Repository.save(c2);
        entity29Repository.save(c3);
    }

    public void action6(Integer id) {
        Entity30 e1 = new Entity30();
        Entity30 e2 = new Entity30();
        Entity30 e3 = new Entity30();

        e1.setOrderDate(LocalDate.parse("2025-06-18"));
        e2.setOrderDate(LocalDate.parse("2025-06-19"));
        e3.setOrderDate(LocalDate.parse("2025-06-20"));

        e1.setInfo("10수생");
        e2.setInfo("대학원생");
        e3.setInfo("국비지원학원");

        Entity29 c1 = entity29Repository.findById(1).get();
        Entity29 c2 = entity29Repository.findById(2).get();
        Entity29 c3 = entity29Repository.findById(3).get();

        e1.setEmployeeId(c1);
        e2.setEmployeeId(c2);
        e3.setEmployeeId(c3);

        entity30Repository.save(e1);
        entity30Repository.save(e2);
        entity30Repository.save(e3);
    }

    public void action7(Integer id) {
        Entity29 entity29 = entity29Repository.findById(id).get();
        System.out.println("entity29 = " + entity29);
    }

    public void action8(Integer id) {
        Entity30 entity30 = entity30Repository.findById(id).get();
        System.out.println("entity30 = " + entity30);
    }

    public void action9(Integer id) {
        Entity30 entity30 = entity30Repository.findById(id).get();
        System.out.println("entity30.getOrderDate() = " + entity30.getOrderDate());
        System.out.println("entity30.getInfo() = " + entity30.getInfo());

        // 직원정보
        System.out.println("entity30.getEmployeeId().getFirstName() = " + entity30.getEmployeeId().getFirstName());
        
    }
}
