package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "my_table28")
@ToString
public class Entity28 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String productName;
    private Integer price;
    private String unit;

    // category_id
//    private Integer categoryId;
    @ManyToOne // foreign key를 갖고 있는 쪽이 다(many 임)
    @JoinColumn(name = "category_id")
    private Entity27 categoryId;
}
