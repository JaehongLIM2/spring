package com.example.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class Entity25Id implements Serializable {
    private static final long serialVersionUID = -5223594581882586038L;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "gender", nullable = false, length = 20)
    private String gender;

    @Column(name = "height", nullable = false)
    private Double height;

    @Column(name = "weight", nullable = false)
    private Double weight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Entity25Id entity = (Entity25Id) o;
        return Objects.equals(this.address, entity.address) &&
               Objects.equals(this.gender, entity.gender) &&
               Objects.equals(this.name, entity.name) &&
               Objects.equals(this.weight, entity.weight) &&
               Objects.equals(this.height, entity.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, gender, name, weight, height);
    }

}