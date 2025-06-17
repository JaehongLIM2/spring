package com.example.spring.repository;

import com.example.spring.entity.Entity17;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface Entity17Repository extends JpaRepository<Entity17, Integer> {


    @Query(value = """
            SELECT *
            FROM jpa.employee
            WHERE birth_date
            BETWEEN :start
            AND     :end
            """, nativeQuery = true)
    List<Entity17> query1(LocalDate start, LocalDate end);

    @Query(value = """
            SELECT *
            FROM jpa.employee
            WHERE first_name like :keyword
            OR last_name like :keyword
            """, nativeQuery = true)
    List<Entity17> query2(String keyword);

    @Query(value = """
            SELECT k
            FROM Entity17 k
            WHERE k.firstName like :keyword
            OR k.lastName like :keyword
            """)
    List<Entity17> query3(@Param("keyword") String keyword);

    List<Entity17> findByBirthDateBetween(LocalDate birthDateAfter, LocalDate birthDateBefore);
}