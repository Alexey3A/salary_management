package com.example.salary_management.service;

import com.example.salary_management.entity.SalarySource;
import com.example.salary_management.repository.SalarySourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalarySourceServiceImpl implements SalarySourceService {
    @Autowired
    SalarySourceRepository sourceRepository;

    @Override
    public SalarySource getSalarySource(long id) {
        SalarySource source = null;
        Optional<SalarySource> optional = sourceRepository.findById(id);
        if (optional.isPresent()) {
            source = optional.get();
        }
        return source;
    }

    @Override
    public List<SalarySource> getAllSalarySource() {
        return sourceRepository.findAll();
    }

    @Override
    public void saveSalarySource(SalarySource source) {
        sourceRepository.save(source);
    }

    @Override
    public void deleteSalarySource(long id) {
        sourceRepository.deleteById(id);
    }
}
