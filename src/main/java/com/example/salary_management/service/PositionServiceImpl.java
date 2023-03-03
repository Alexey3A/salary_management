package com.example.salary_management.service;

import com.example.salary_management.entity.PositionLevel;
import com.example.salary_management.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionRepository positionRepository;

    @Override
    public PositionLevel getPosition(long id) {
        PositionLevel position = null;
        Optional<PositionLevel> optional = positionRepository.findById(id);
        if (optional.isPresent()) {
            position = optional.get();
        }
        return position;
    }

    @Override
    public List<PositionLevel> getAllPosition() {
        return positionRepository.findAll();
    }

    @Override
    public void savePosition(PositionLevel position) {
        positionRepository.save(position);
    }

    @Override
    public void deletePosition(long id) {
        positionRepository.deleteById(id);
    }
}
