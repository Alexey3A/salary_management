package com.example.salary_management.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "salary_source")
public class SalarySource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String salarySourceName;
    @Column(name = "sum")
    private double salarySourceSum;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="salary_source_worker"
            , joinColumns = @JoinColumn(name = "source_id")
            , inverseJoinColumns = @JoinColumn(name="worker_id"))
    private List<Worker> workerList;

    public SalarySource() {
    }

    public SalarySource(String salarySourceName, double salarySourceSum, List<Worker> workerList) {
        this.salarySourceName = salarySourceName;
        this.salarySourceSum = salarySourceSum;
        this.workerList = workerList;
    }

    public void addWorkerToWorkerList(Worker worker){
        if(workerList.isEmpty()){
            workerList = new ArrayList<>();
        }
        workerList.add(worker);
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSalarySourceName() {
        return salarySourceName;
    }

    public void setSalarySourceName(String salarySourceName) {
        this.salarySourceName = salarySourceName;
    }

    public double getSalarySourceSum() {
        return salarySourceSum;
    }

    public void setSalarySourceSum(double salarySourceSum) {
        this.salarySourceSum = salarySourceSum;
    }
}
