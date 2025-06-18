package com.example.spring.entity;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Entity26Id {
    private int id;
    private int id2;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entity26Id that = (Entity26Id) o;
        return id == that.id && id2 == that.id2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id2);
    }
}
