package com.example.salary_management.service;

import com.example.salary_management.entity.StructuralDivision;

import java.util.List;

public interface StructuralDivisionService {

    StructuralDivision getDivision(long id);

    List<StructuralDivision> getAllDivision();

    void saveDivision(StructuralDivision division);

    void deleteDivision(long id);
}
