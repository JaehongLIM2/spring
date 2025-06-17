package com.example.spring.service;

import com.example.spring.entity.Entity16;
import com.example.spring.entity.Entity19;
import com.example.spring.repository.Entity16Repository;
import com.example.spring.repository.Entity19Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Service4 {
    private final Entity16Repository entity16Repository;
    private final Entity19Repository entity19Repository;

    public void action1() {
        System.out.println("1111111111111페이지");
        // paging
        Page<Entity16> list = entity16Repository.findAll(PageRequest.of(1 - 1, 10));
        List<Entity16> data = list.getContent();
        for (Entity16 entity16 : data) {
            System.out.println(entity16);
        }

        System.out.println("222222222222222페이지");
        List<Entity16> list1 = entity16Repository.findAll(PageRequest.of(2 - 1, 10)).getContent();
        for (Entity16 entity16 : list1) {
            System.out.println(entity16);
        }
    }

    public void action2() {
        System.out.println("777777777777개씩 1111111111페이지");
        List<Entity19> content = entity19Repository.findAll(PageRequest.of(1 - 1, 7)).getContent();
        for (Entity19 entity19 : content) {
            System.out.println(entity19);
        }
        System.out.println("777777777777개씩 2222222222페이지");
        List<Entity19> content1 = entity19Repository.findAll(PageRequest.of(2 - 1, 7)).getContent();
        for (Entity19 entity19 : content1) {
            System.out.println(entity19);
        }
    }

    public void action3() {
        // 페이징 + 정렬
        System.out.println("1111111111111페이지");
        List<Entity19> list1 = entity19Repository
                .findAll(PageRequest.of((1 - 1), 7, Sort.by("productName")))
                .getContent();
        for (Entity19 entity19 : list1) {
            System.out.println(entity19);
        }
    }

    public void action4() {
        // 계약명 기준 ** 역순 ** 으로 1페이지 출력하기
        List<Entity16> list4 = entity16Repository
                .findAll(PageRequest.of(1 - 1, 10, Sort.by("contactName").descending()))
                .getContent();
        for (Entity16 entity16 : list4) {
            System.out.println(entity16);
        }
    }
    public void action5() {
        // 가격 역순으로 10개씩 페이지 상픔 내용 보기
        Page<Entity19> price = entity19Repository.findAll(PageRequest.of(1 - 1, 10, Sort.by("price").descending()));
        for (Entity19 entity19 : price) {
            System.out.println(entity19.getPrice() + " / " + entity19.getUnit());
        }
    }
    public void action6(Integer page) {
        // 91 레코드
        // 1 ~ 10 페이지

        System.out.println("################### "+ page +" ###################");
        Page<Entity16> page1 = entity16Repository
                .findAll(PageRequest.of(page - 1, 10, Sort.by("id").descending()));

        List<Entity16> content1 = page1.getContent();
        int totalPages = page1.getTotalPages(); // 10
        long totalElements = page1.getTotalElements(); // 91

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);

        for (Entity16 entity16 : content1) {
            System.out.println(entity16);
        }
    }

    public void action7(Integer page) {
        System.out.println("################### "+ page +"page ###################");

        Page<Entity19> page1 = entity19Repository
                .findAll(PageRequest.of(page - 1, 10, Sort.by("price")));

        List<Entity19> content1 = page1.getContent();
        boolean next = page1.hasNext();
        int totalPages = page1.getTotalPages();
        long totalElements = page1.getTotalElements();

        System.out.println("총 페이지 = " + totalPages);
        System.out.println("총 레코드 = " + totalElements);
        System.out.println("다음 페이지 여부 : " + next);
        for (Entity19 entity19 : content1) {
            System.out.println(entity19);
        }
    }
}
