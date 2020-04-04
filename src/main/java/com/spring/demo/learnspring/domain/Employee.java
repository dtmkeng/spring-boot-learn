package com.spring.demo.learnspring.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FIRST_NAME")
    private String fistName;
    @Column(name = "LAST_NAME")
    private String lastName;

    public Employee() {

    }

    public Employee(String fistName, String lastName) {
        this.fistName = fistName;
        this.lastName = lastName;
    }
}
