package com.spring.demo.learnspring.repository;

import com.spring.demo.learnspring.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
