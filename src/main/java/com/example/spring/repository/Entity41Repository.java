package com.example.spring.repository;

import com.example.spring.dto.ProuctInfo2;
import com.example.spring.entity.Entity41;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Entity41Repository extends JpaRepository<Entity41, Integer> {
    @Query(value = """
            SELECT t.order_date, p.name product_name, p.price, t.quantity, m.name category_name
            FROM my_table39 p
                     JOIN my_table40 m on m.id = p.category_id
                     JOIN my_table41 t on p.id = t.product_id;
            """, nativeQuery = true)
    List<ProuctInfo2> query1();
}