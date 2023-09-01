package com.wipro.springjpatest.controller;

import com.wipro.springjpatest.dao.EmployeeRepository;
import com.wipro.springjpatest.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee-service")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{empId}")
    public Employee getEmployee(@PathVariable Long empId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(empId);
        Employee employee = employeeOptional.get();
        return employee;
    }

    @PostMapping("/employee")
    public Employee save(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/employee/{empId}")
    public void delete(@PathVariable Long empId) {
        employeeRepository.deleteById(empId);

    }
}
