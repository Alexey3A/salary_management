package com.example.salary_management.repository;

import com.example.salary_management.entity.PositionLevel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PositionRepository extends JpaRepository<PositionLevel, Long> {
}
