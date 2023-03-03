package com.example.salary_management.controller;

import com.example.salary_management.entity.PositionLevel;
import com.example.salary_management.entity.StructuralDivision;
import com.example.salary_management.repository.PositionRepository;
import com.example.salary_management.repository.StructuralDivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private StructuralDivisionRepository divisionRepository;
    @Autowired
    private PositionRepository positionRepository;

    @PostMapping("/div")
    public StructuralDivision addNewDivision(@RequestBody StructuralDivision division) {
        divisionRepository.save(division);
        return division;
    }

    @PostMapping("/pos")
    public PositionLevel addNewPosition(@RequestBody PositionLevel position){
        positionRepository.save(position);
        return position;
    }
}
