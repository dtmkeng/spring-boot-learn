package com.spring.demo.learnspring.controller;

import com.spring.demo.learnspring.domain.Employee;
import com.spring.demo.learnspring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employee")
    @ResponseBody
    public List<Employee> findAll() {
        return employeeService.listAll();
    }

    @RequestMapping("/employee/{id}")
    @ResponseBody
    public Employee getEmployee(@PathVariable Integer id){
       return employeeService.findById(id);
    }
}
