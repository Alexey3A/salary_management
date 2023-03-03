package com.example.salary_management.repository;

import com.example.salary_management.entity.SalarySource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalarySourceRepository extends JpaRepository<SalarySource, Long> {
}
