package com.wipro.springjpatest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    private Long empId;
    private String empName;
    private String email;
    @OneToMany(targetEntity = Task.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_fk", referencedColumnName = "empId")
    private List<String> tasks;

    public Employee(Long empId, String empName, String email, List<String> tasks) {
        this.empId = empId;
        this.empName = empName;
        this.email = email;
        this.tasks = tasks;
    }


    public Employee() {
    }

    public List<String> getTasks() {
        return tasks;
    }

    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
