package com.example.demo.dao;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getEmplyees();
    Employee getEmployee(int id);
    void save(Employee employee);
    void delete(int id);
}
