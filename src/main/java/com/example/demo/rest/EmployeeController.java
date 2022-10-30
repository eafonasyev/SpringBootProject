package com.example.demo.rest;

import com.example.demo.entity.Employee;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private ServiceImpl service;

    @GetMapping("/emp")
    public List<Employee> getEmployees(){
      return    service.getEmplyees();
    }

    @GetMapping("/emp/{Id}")
    public Employee getEmployee(@PathVariable int Id){
       Employee employees = service.getEmployee(Id);
        return    employees;
    }
    @DeleteMapping("/emp/{Id}")
    public void empDel(@PathVariable int Id){
        service.delete(Id);
    }
    @PutMapping("/emp")
    public void update(@RequestBody Employee employees){
        if (employees.getId()==0){
            System.out.println("не указан id");
            return;
        }
        service.save(employees);
    }
    @PostMapping("/emp")
    public void create(@RequestBody Employee employees){
        service.save(employees);
    }
}
