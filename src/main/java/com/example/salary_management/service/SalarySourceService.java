package com.example.salary_management.service;

import com.example.salary_management.entity.SalarySource;

import java.util.List;

public interface SalarySourceService {

    SalarySource getSalarySource(long id);

    List<SalarySource> getAllSalarySource();

    void saveSalarySource(SalarySource source);

    void deleteSalarySource(long id);
}
