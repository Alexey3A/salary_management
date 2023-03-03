package com.example.salary_management.service;

import com.example.salary_management.entity.Worker;
import com.example.salary_management.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public Worker getWorker(long id) {
        Worker worker = null;
        Optional<Worker> optional = workerRepository.findById(id);
        if (optional.isPresent()) {
            worker = optional.get();
        }
        return worker;
    }

    @Override
    public List<Worker> getAllWorker() {
        return workerRepository.findAll();
    }

    @Override
    public void saveWorker(Worker worker) {
        workerRepository.save(worker);
    }

    @Override
    public void deleteWorker(long id) {
        workerRepository.deleteById(id);
    }
}
