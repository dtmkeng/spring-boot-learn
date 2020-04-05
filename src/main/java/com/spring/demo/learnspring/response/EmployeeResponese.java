package com.spring.demo.learnspring.response;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class EmployeeResponese {

    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FIRST_NAME")
    private String fistName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "DEPARTMENT")
    private String department;
}
