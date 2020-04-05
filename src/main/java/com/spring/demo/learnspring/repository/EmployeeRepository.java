package com.spring.demo.learnspring.repository;


import com.spring.demo.learnspring.domain.Employee;
import com.spring.demo.learnspring.response.EmployeeResponese;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    @Transactional
    public void delete(Employee employee) {
        entityManager.remove(employee);
    }

    public List<Employee> findByFirstName(String firstName) {
      Query query =  entityManager.createQuery("from Employee q where q.fistName = :FIRST_NAME ");
      query.setParameter("FIRST_NAME", firstName);
      return query.getResultList();
    }

    public List<EmployeeResponese> findByNativeQuery() {
        Query query = entityManager.createNativeQuery(
                "SELECT e.id as ID, " +
                        "e.first_name as FIRST_NAME, " +
                        "e.last_name as LAST_NAME, " +
                        "'IT' as DEPARTMENT " +
                        " FROM EMPLOYEE e "
        , EmployeeResponese.class);
        return query.getResultList();
    }

}
