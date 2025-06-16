package com.example.spring.repository;

import com.example.spring.entity.Entity11;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository
// JpaRepository 를 상속받으면 생략가능
public interface Entity11Repository extends JpaRepository<Entity11, Integer> {

}
