package com.example.spring.service;

import com.example.spring.entity.Entity16;
import com.example.spring.repository.Entity16Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Service5 {
    private final Entity16Repository entity16Repository;

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

    public void action15(Integer id) {
        entity16Repository.deleteById(id);
    }

    public void action6(String country) {
        entity16Repository.deleteByCountry(country);
    }
}
