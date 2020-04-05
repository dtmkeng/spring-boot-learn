package com.spring.demo.learnspring.service;

import com.spring.demo.learnspring.domain.Employee;
import com.spring.demo.learnspring.exception.UnprocessableException;
import com.spring.demo.learnspring.repository.EmployeeReportRepository;
import com.spring.demo.learnspring.repository.EmployeeRepository;
import com.spring.demo.learnspring.response.EmployeeResponese;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeReportRepository employeeReportRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> listAll(){
        return employeeReportRepository.findAll();
    }

    public Employee findById(Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new UnprocessableException("not found employee this id"));
        return employee;
    }

    public void create(Employee employee) {
        employeeReportRepository.save(employee);
    }

    public void update(Integer id, Employee employee) {
        Employee emp = findById(id);
        if (emp != null) {
            emp.setLastName(employee.getLastName());
            emp.setFistName(employee.getFistName());
            employeeReportRepository.save(emp);
        }
    }

    public void delete(Integer id) {
        Employee emp = findById(id);
        if (emp != null) {
            employeeReportRepository.delete(emp);
        }
    }

    public List<Employee> findByFirstName(String firstName) {
        return employeeReportRepository.findByFirstName(firstName);
    }

    public List<EmployeeResponese> getNativeQuery() {
        return employeeReportRepository.findByNativeQuery();
    }
}
