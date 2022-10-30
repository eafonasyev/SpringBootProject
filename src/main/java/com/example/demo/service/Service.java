package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;

public interface Service {
    List<Employee> getEmplyees();
    Employee getEmployee(int id);
    void save(Employee employee);
    void delete(int id);
}
