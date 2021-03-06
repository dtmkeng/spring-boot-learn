package com.spring.demo.learnspring.controller;

import com.spring.demo.learnspring.domain.Employee;
import com.spring.demo.learnspring.response.EmployeeResponese;
import com.spring.demo.learnspring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.listAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id){
       return employeeService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody Employee employee) {
        employeeService.create(employee);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Employee employee) {
        employeeService.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        employeeService.delete(id);
    }

    @GetMapping("/firstName/{firstName}")
    public List<Employee> findByFirstName(@PathVariable String firstName) {
        return employeeService.findByFirstName(firstName);
    }

    @GetMapping("/nativeQuery")
    public List<EmployeeResponese> getEmployeeNativeQuery(){
        return employeeService.getNativeQuery();
    }
}
