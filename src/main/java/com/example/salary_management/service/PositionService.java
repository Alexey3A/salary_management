package com.example.salary_management.service;

import com.example.salary_management.entity.PositionLevel;

import java.util.List;

public interface PositionService {

    PositionLevel getPosition(long id);

    List<PositionLevel> getAllPosition();

    void savePosition(PositionLevel position);

    void deletePosition(long id);
}
