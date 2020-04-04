package com.spring.demo.learnspring.repository;


import com.spring.demo.learnspring.domain.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    public List<Employee> findAll() {
       return entityManager.createQuery("from Employee").getResultList();
    }

    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }
}
