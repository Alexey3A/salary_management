package com.example.salary_management.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "divisions")
public class StructuralDivision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String divisionName;
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE
            , CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "division")
    private List<Worker> workerList;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="divisions_positions"
                    , joinColumns = @JoinColumn(name="division_id")
                    , inverseJoinColumns = @JoinColumn(name="position_id"))
    private List<PositionLevel> positionList;

    public StructuralDivision() {
    }

    public StructuralDivision(String divisionName) {
        this.divisionName = divisionName;
    }

    public void addWorkerToStructuralDivision(Worker worker) {
        if (workerList.isEmpty()) {
            workerList = new ArrayList<>();
        }
        workerList.add(worker);
        worker.setDivision(this);
    }

    public void addPositionToDivision(PositionLevel position){
        if(positionList.isEmpty()) {
            positionList = new ArrayList<>();
        }
        positionList.add(position);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }

    @Override
    public String toString() {
        return divisionName;
    }
}
