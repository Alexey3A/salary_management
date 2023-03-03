package com.example.salary_management.service;

import com.example.salary_management.entity.Worker;
import org.springframework.stereotype.Service;

import java.util.List;

public interface WorkerService {
    Worker getWorker(long id);
    List<Worker> getAllWorker();
    void saveWorker(Worker worker);
    void deleteWorker(long id);
}
