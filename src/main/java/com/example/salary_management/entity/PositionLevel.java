package com.example.salary_management.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "positions")
public class PositionLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="name")
    private String positionName;
    @Column(name="salary")
    private double basicSalary;
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE
            , CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "positionLevel")
    private List<Worker> workerList;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="divisions_positions"
            , joinColumns = @JoinColumn(name="position_id")
            , inverseJoinColumns = @JoinColumn(name="division_id"))
    private List<StructuralDivision> divisionList;

    public PositionLevel() {
    }

    public PositionLevel(String positionName) {
        this.positionName = positionName;
    }

    public PositionLevel(String positionName, double basicSalary) {
        this.positionName = positionName;
        this.basicSalary = basicSalary;
    }

    public void addWorkerToPosition(Worker worker) {
        if(workerList.isEmpty()) {
            workerList = new ArrayList<>();
        }
        workerList.add(worker);
        worker.setPositionLevel(this);
    }

    public void addPositionToDivision(StructuralDivision division){
        if(divisionList.isEmpty()){
            divisionList = new ArrayList<>();
        }
        divisionList.add(division);
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }

    public List<StructuralDivision> getDivisionList() {
        return divisionList;
    }

    public void setDivisionList(List<StructuralDivision> divisionList) {
        this.divisionList = divisionList;
    }

    @Override
    public String toString() {
        return  positionName;
    }
}
