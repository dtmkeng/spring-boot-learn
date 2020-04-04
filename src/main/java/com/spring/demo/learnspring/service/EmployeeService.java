package com.spring.demo.learnspring.service;

import com.spring.demo.learnspring.domain.Employee;
import com.spring.demo.learnspring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> listAll(){
        return employeeRepository.findAll();
    }

    public Employee findById(Integer id) {
        return employeeRepository.findById(id);
    }

    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    public void update(Integer id, Employee employee) {
        Employee emp = findById(id);
        if (emp != null) {
            emp.setLastName(employee.getLastName());
            emp.setFistName(employee.getFistName());
            employeeRepository.save(emp);
        }
    }

    public void delete(Integer id) {
        Employee emp = findById(id);
        if (emp != null) {
            employeeRepository.delete(emp);
        }
    }
}
