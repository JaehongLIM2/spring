package com.example.spring.repository;

import com.example.spring.entity.Entity34;
import com.example.spring.entity.Entity35;
import com.example.spring.entity.Entity36;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface Entity36Repository extends JpaRepository<Entity36, Integer> {

  @Modifying
  @Transactional
  @Query("DELETE FROM Entity36 e WHERE e.student.id = :studentId")
  void deleteByStudentId(@Param("studentId") int studentId);

  void deleteByLectureId(int i);
}