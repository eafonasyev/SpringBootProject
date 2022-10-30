package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BaseController {

    private ServiceImpl service;

    @Autowired
    public BaseController(ServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showPage(Model model){
        return "home";
    }

    @GetMapping("/list")
    public String getListEmployees(Model model){
        List<Employee> employees = service.getEmplyees();
        model.addAttribute("employee",employees);
        return "list-employees";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Employee employees = new Employee();
        model.addAttribute("employee",employees);
        return "employee-form";
    }

    @GetMapping("/list{id}")
    public String getListEmployees(Model model,int id){
        Employee employees = service.getEmployee(id);
        model.addAttribute("employee",employees);
        return "list-employees";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute(name = "employee")  Employee employee){
        service.save(employee);
        return "redirect:/list";
    }

    @PutMapping("/update")
    public String update(@ModelAttribute(name = "employee") Employee employee){
        service.save(employee);
        return "redirect:/list";
    }

    @DeleteMapping("/list")
    public void delete(int id){
        service.delete(id);
    }

}
