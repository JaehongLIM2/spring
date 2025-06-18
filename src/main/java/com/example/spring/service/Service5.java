package com.example.spring.service;

import com.example.spring.entity.Entity16;
import com.example.spring.entity.Entity20;
import com.example.spring.repository.Entity16Repository;
import com.example.spring.repository.Entity18Repository;
import com.example.spring.repository.Entity20Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Service5 {
    private final Entity16Repository entity16Repository;
    private final Entity20Repository entity20Repository;
    private final Entity18Repository entity18Repository;

    public void action1(Integer page) {
        Page<Entity16> page1 = entity16Repository
                .findAll(PageRequest.of(page - 1, 10, Sort.by("id").descending()));

        List<Entity16> content = page1.getContent();
        for (Entity16 entity16 : content) {
            System.out.println(entity16);
        }
    }

    public void action2(String country) {
        List<Entity16> list = entity16Repository.findByCountry(country);
        for (Entity16 entity16 : list) {
            System.out.println(entity16);
        }
    }

    public void action3(String country, Integer page) {
        Page<Entity16> page1 = entity16Repository
                .findByCountry(country,
                        PageRequest.of(page - 1, 10, Sort.by("id").descending()));
        List<Entity16> content = page1.getContent();
        for (Entity16 entity16 : content) {
            System.out.println(entity16);
        }
    }


    public void action4(String keyword, Integer page) {
         List<Entity16> list = entity16Repository
                .findByCustomerNameContainsOrContactNameContains(keyword, keyword,
                        PageRequest.of(page - 1, 10, Sort.by("id").descending()))
                 .getContent();
         for (Entity16 entity16 : list) {
             System.out.println(entity16);
         }

    }

    public void action5(Integer id) {
        entity16Repository.deleteById(id);
    }

    @Transactional
    public void action6(String country) {
        entity16Repository.deleteByCountry(country);
    }

    public void action7() {
        Entity20 a = entity20Repository.findById("a").get();
        Entity20 b = entity20Repository.findById("b").get();
        a.setMoney(a.getMoney() - 500);
        entity20Repository.save(a);
        if (true) {
            throw new RuntimeException("네트워크 오류");
        }
        b.setMoney(b.getMoney() + 500);

        entity20Repository.save(b);
    }

    @Transactional
    public void action8() {
        // 보통 service의 하나의 메소드가 하나의 transaction 임
        // -> @Transactional 을 어노테이션을 service의 모든 메소드에 붙여야함
        Entity20 a = entity20Repository.findById("a").get();
        Entity20 b = entity20Repository.findById("b").get();
        a.setMoney(a.getMoney() - 500);
        entity20Repository.save(a);
        if (true) {
            throw new RuntimeException("네트워크 오류");
        }
        b.setMoney(b.getMoney() + 500);

        entity20Repository.save(b);
    }

    @Transactional
    public void action9(String country) {
        entity18Repository.deleteByCountry(country);
    }

    @Transactional
    public void action10(String country) {
        // SELECT 후 하나씩 지움 : 성능 이슈가 있음(양이 많으면 느려질 수 있음)
//        entity16Repository.deleteByCountry(country);

        // -> JPQL이나 SQL로 직접 작성해서 지워야함
        entity16Repository.bulkDeleteByCountry(country);
    }

    @Transactional
    public void action11(String country) {
        entity18Repository.deleteCountry(country);
    }
}












