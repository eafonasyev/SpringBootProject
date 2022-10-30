package com.example.demo.service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    EmployeeDao employeeDao;

    @Autowired
    public ServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public List<Employee> getEmplyees() {
        return employeeDao.getEmplyees();
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDao.getEmployee(id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
       employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
       employeeDao.delete(id);
    }
}
