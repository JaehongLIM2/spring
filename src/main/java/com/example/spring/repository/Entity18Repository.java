package com.example.spring.repository;

import com.example.spring.entity.Entity18;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Entity18Repository extends JpaRepository<Entity18, Integer> {
    // findById
    // save
    // deleteById

    // SQL
    // JPQL

    // 메소드 이름으로 쿼리 만들기

    /*
    SELECT * FROM supplier WHERE country =:country
     */

    List<Entity18> findByCountry(String country);

    /*
    SELECT * FROM supplier WHERE city =:city
     */
    List<Entity18> findByCity(String city);

    /*
    SELECT * FROM supplier WHERE supplier_name LIKE :keyword
     */

    // keyword 에 %(wildcard) 붙여서 호출
    List<Entity18> findBySupplierNameLike(String keyword);

    /*
    SELECT * FROM supplier WHERE supplier_name LIKE :keyword
     */

    // keyword 에 %(wildcard) 안붙여서 호출
    List<Entity18> findBySupplierNameContains(String keyword);

    /*
    SELECT * FROM supplier WHERE country IN(?, ?, ?)
     */
    List<Entity18> findByCountryIn(List<String> country);
}