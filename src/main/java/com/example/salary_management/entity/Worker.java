package com.example.salary_management.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="workers")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name = "surname")
    private String surname;
    @Column(name="name")
    private String name;
    @Column(name = "patronymic")
    private String patronymic;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE
            , CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="position")
    private PositionLevel positionLevel;
    @Column(name="total_salary")
    private double totalSalary;
    @Column(name="minimal_salary")
    private double minimalSalary;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE
            , CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="division")
    private StructuralDivision division;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="salary_source_worker"
            , joinColumns = @JoinColumn(name = "worker_id")
            , inverseJoinColumns = @JoinColumn(name="source_id"))
    private List<SalarySource> salarySourceList;

    public Worker() {
    }

    public Worker(long id, String surname, String name, String patronymic) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public void addSalarySourceToWorker(SalarySource salarySource){
        if(salarySourceList.isEmpty()) {
            salarySourceList = new ArrayList<>();
        }
        salarySourceList.add(salarySource);
    }

    public List<SalarySource> getSalarySourceList() {
        return salarySourceList;
    }

    public void setSalarySourceList(List<SalarySource> salarySourceList) {
        this.salarySourceList = salarySourceList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public PositionLevel getBasicSalary() {
        return positionLevel;
    }

    public void setBasicSalary(PositionLevel positionLevel) {
        this.positionLevel = positionLevel;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public double getMinimalSalary() {
        return minimalSalary;
    }

    public void setMinimalSalary(double minimalSalary) {
        this.minimalSalary = minimalSalary;
    }

    public PositionLevel getPositionLevel() {
        return positionLevel;
    }

    public void setPositionLevel(PositionLevel positionLevel) {
        this.positionLevel = positionLevel;
    }

    public StructuralDivision getDivision() {
        return division;
    }

    public void setDivision(StructuralDivision division) {
        this.division = division;
    }
}
