package com.example.spring.repository;

import com.example.spring.entity.Entity16;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface Entity16Repository extends JpaRepository<Entity16, Integer> {
    // findById
    // save
    // deleteById

    // 직접 만드는 쿼리
    @Query(value = """
            SELECT *
            FROM customer
            WHERE country = :country
            """, nativeQuery = true)
    List<Entity16> query1(String country);

    @Query(value = """
            SELECT *
            FROM customer
            WHERE city = :city
            """, nativeQuery = true)
    List<Entity16> query2(String city);


    @Query(value = """
            SELECT *
            FROM customer
            WHERE city =:city1
            OR    city =:city2
            """, nativeQuery = true)
    List<Entity16> query3(String city1, String city2);

    @Query(value = """
            SELECT *
            FROM customer
            WHERE customer_name like :keyword
            """, nativeQuery = true)
    List<Entity16> query4(String keyword);

    /*
    SQL
    @Query(value = """
            SELECT *
            FROM customer
            WHERE country = :country
            """, nativeQuery = true)
     */

    // JPQL : Entity 대상으로 쿼리를 날림
    @Query(value = """
            SELECT e
            FROM Entity16 e
            WHERE e.country = :country
            """)
    List<Entity16> query5(String country);

    // 연습
    // 도시 이름으로 고객을 조회하느 쿼리 JPQL 로 작성
    // service, controller

    @Query(value = """
            SELECT c
            FROM Entity16 c
            WHERE c.city = :city
            """)
    List<Entity16> query6(String city);

    /* SQL
    @Query(value = """
            SELECT *
            FROM customer
            WHERE customer_name like :keyword
            """, nativeQuery = true)
     */
    @Query(value = """
            SELECT c
            FROM Entity16 c
            WHERE c.customerName like :keyword
            """)
    List<Entity16> query7(String keyword);


    /* JPQL
    @Query(value = """
            SELECT e
            FROM Entity16 e
            WHERE e.country = :country
            """)
     */
    List<Entity16> findByCountry(String country);

    // sql, jpql 안써도 됨
    // SELECT * FROM customer WHERE city = :city
    List<Entity16> findByCity(String city);

    Page<Entity16> findByCountry(String country, PageRequest pageRequest);

    List<Entity16> findByCustomerNameContains(String customerName);


    Page<Entity16> findByCustomerNameContainsOrContactNameContains(String keyword, String keyword1, Pageable pageable);


    void deleteByCountry(String country);
}


