package com.example.salary_management.service;

import com.example.salary_management.entity.StructuralDivision;
import com.example.salary_management.repository.StructuralDivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StructuralDivisionServiceImpl implements StructuralDivisionService {

    @Autowired
    StructuralDivisionRepository divisionRepository;

    @Override
    public StructuralDivision getDivision(long id) {
        StructuralDivision division = null;
        Optional<StructuralDivision> optional = divisionRepository.findById(id);
        if (optional.isPresent()) {
            division = optional.get();
        }
        return division;
    }

    @Override
    public List<StructuralDivision> getAllDivision() {
        return divisionRepository.findAll();
    }

    @Override
    public void saveDivision(StructuralDivision division) {
        divisionRepository.save(division);
    }

    @Override
    public void deleteDivision(long id) {
        divisionRepository.deleteById(id);
    }
}
