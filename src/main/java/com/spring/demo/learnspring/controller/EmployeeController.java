package com.spring.demo.learnspring.controller;

import com.spring.demo.learnspring.domain.Employee;
import com.spring.demo.learnspring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    @ResponseBody
    public List<Employee> findAll() {
        return employeeService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Employee getEmployee(@PathVariable Integer id){
       return employeeService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public void create(@RequestBody Employee employee) {
        employeeService.create(employee);
    }
}
