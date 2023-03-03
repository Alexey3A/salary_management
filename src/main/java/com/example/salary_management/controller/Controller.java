package com.example.salary_management.controller;

import com.example.salary_management.entity.PositionLevel;
import com.example.salary_management.entity.SalarySource;
import com.example.salary_management.entity.StructuralDivision;
import com.example.salary_management.entity.Worker;
import com.example.salary_management.repository.PositionRepository;
import com.example.salary_management.repository.SalarySourceRepository;
import com.example.salary_management.repository.StructuralDivisionRepository;
import com.example.salary_management.repository.WorkerRepository;
import com.example.salary_management.service.PositionService;
import com.example.salary_management.service.SalarySourceService;
import com.example.salary_management.service.StructuralDivisionService;
import com.example.salary_management.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    public WorkerService workerService;
    @Autowired
    SalarySourceService sourceService;
    @Autowired
    StructuralDivisionService divisionService;
    @Autowired
    PositionService positionService;

    @Autowired
    public WorkerRepository workerRepository;
    @Autowired
    public StructuralDivisionRepository divisionRepository;
    @Autowired
    public PositionRepository positionRepository;
    @Autowired
    public SalarySourceRepository salarySourceRepository;

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("workers", workerService.getAllWorker());
        List<SalarySource> sourceList = sourceService.getAllSalarySource();
        model.addAttribute("sources", sourceList);
        double sourceTotalSum = 0;
        for (SalarySource salarySource : sourceList) {
            sourceTotalSum += salarySource.getSalarySourceSum();
        }
        model.addAttribute("totalSum", sourceTotalSum);
        return "index";
    }

    @GetMapping("/addNewWorker")
    public String addNewWorker(Model model) {
        model.addAttribute("worker", new Worker());
        List<StructuralDivision> divisions = divisionRepository.findAll();
        model.addAttribute("divisions", divisions);
        return "worker-info";
    }

    @PostMapping("/saveWorker")
    public String saveWorker(@ModelAttribute("worker") Worker worker) {
        if (worker.getDivision() == null || worker.getDivision().getDivisionName().equals("не указано")) {
            StructuralDivision division = divisionService.getDivision(1L);
            worker.setDivision(division);
        }
        if (worker.getPositionLevel() == null
                || worker.getPositionLevel().getId() == 1) {
            PositionLevel position = positionService.getPosition(1L);
            worker.setPositionLevel(position);
        }
        workerRepository.save(worker);
        return "redirect:/";
    }

    @GetMapping("/workerInfo/{id}")
    public String showWorkerInfo(@PathVariable(value = "id") long id, Model model) {
        Worker worker = workerService.getWorker(id);
        List<StructuralDivision> divisions = divisionRepository.findAll();
        model.addAttribute("worker", worker);
        model.addAttribute("divisions", divisions);
        return "worker-info";
    }

    @GetMapping("/deletingAnWorker/{id}")
    public String deletingAnWorker(@PathVariable(value = "id") long id) {
        workerRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/addNewDivision")
    public String addNewDivision(Model model){
        StructuralDivision division = new StructuralDivision();
        model.addAttribute("division", division);
        return "division-info";
    }

    @PostMapping("/saveDivision")
    public String saveStructuralDivision(@ModelAttribute("division") StructuralDivision division, Model model){
        divisionRepository.save(division);
        List<StructuralDivision> divisions = divisionRepository.findAll();
        //model.addAttribute("divisions", divisions);
        return "redirect:/";
    }

    @GetMapping("/allDivisions")
    public String showAllDivisions(Model model){
        List<StructuralDivision> divisions = divisionRepository.findAll();
        model.addAttribute("divisions", divisions);
        return "divisions-list";
    }

    @GetMapping("/divisionInfo/{id}")
    public String showDivisionInfo(@PathVariable(value="id") long id, Model model) {
        StructuralDivision division = divisionService.getDivision(id);
        model.addAttribute("division", division);
        return "division-info";
    }

    @GetMapping("/addNewSalarySource")
    public String addNewSalarySource(Model model) {
        model.addAttribute("source", new SalarySource());
        return "source-info";
    }

    @PostMapping("/saveSource")
    public String saveSalarySource(@ModelAttribute("source") SalarySource salarySource) {
        salarySourceRepository.save(salarySource);
        return "redirect:/";
    }

    @GetMapping("/addNewPosition")
    public String addNewPosition(Model model){
        PositionLevel position = new PositionLevel();
        model.addAttribute("position", position);
        return "position-info";
    }

    @PostMapping("/savePosition")
    public String savePosition(@ModelAttribute("position") PositionLevel position, Model model){
        positionRepository.save(position);
        List<PositionLevel> positions = positionRepository.findAll();
        return "redirect:/";
    }

    @GetMapping("/allPositions")
    public String showAllPositions(Model model){
        List<PositionLevel> positions = positionRepository.findAll();
        model.addAttribute("positions", positions);
        return "positions-list";
    }

    @GetMapping("/positionInfo/{id}")
    public String showPositionInfo(@PathVariable(value="id") long id, Model model) {
        PositionLevel position = positionService.getPosition(id);
        model.addAttribute("position", position);
        return "position-info";
    }
}
