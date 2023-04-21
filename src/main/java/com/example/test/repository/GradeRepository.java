package com.example.test.repository;

import com.example.test.entety.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade,Integer> {
}
