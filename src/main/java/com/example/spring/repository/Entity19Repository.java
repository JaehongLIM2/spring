package com.example.spring.repository;

import com.example.spring.entity.Entity19;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface Entity19Repository extends JpaRepository<Entity19, Integer> {
    // findById

    //연습
    /*
    SELECT *
    FROM product
    WHERE category_id =:category_id
     */
    List<Entity19> findByCategoryId(Integer categoryId);

    /*
    SELECT *
    FROM product
    WHERE supplier_id =:supplier_id
     */
    List<Entity19> findBySupplierId(Integer supplierId);

    /*
    SELECT *
    FROM product
    WHERE price
    BETWEEN :p1 ANA :p2
     */
    List<Entity19> findByPriceBetween(Double p1, Double p2);

    /*
    SELECT *
    FROM product
    WHERE price >= :price
     */
    List<Entity19> findByPriceGreaterThan(Double p1);


    /*
    SELECT *
    FROM product
    WHERE category_id IN (?, ?...?)
     */
    List<Entity19> findByCategoryIdIn(List<Integer> categoryIds);

    /*
    SELECT *
    FROM product
    WHERE product_name LIKE :keyword
    - 1. with wildcard
    - 2. without wildcard
     */
    List<Entity19> findByProductNameContains(String productName);

    List<Entity19> findByProductNameLike(String productName);

    /* SQL
    SELECT *
    FROM product
    WHERE category_id =:id
    ORDER BY price DESC
     */

    // * SQL (Table 조회 / 속성명)
    @Query(value = """
            SELECT *
            FROM product
            WHERE category_id =:id
            ORDER BY price DESC
            """, nativeQuery = true)
    List<Entity19> query1(Integer id);

    // * JPQL (Entity 조회 / 필드명)
    @Query(value = """
            SELECT p
            FROM Entity19 p
            WHERE p.categoryId =:id
            ORDER BY p.price DESC
            """)
    List<Entity19> query2(Integer id);

    // ORDER BY PRICE ASC
    List<Entity19> findByCategoryIdOrderByPriceAsc(Integer id);

    // ORDER BY PRICE DESC
    List<Entity19> findByCategoryIdOrderByPriceDesc(Integer id);
}