package com.spring.demo.learnspring;

import com.spring.demo.learnspring.domain.Employee;
import com.spring.demo.learnspring.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LearnSpringApplication {

	@Bean
	public CommandLineRunner app(EmployeeRepository employeeRepository) {
		return (args -> {
			employeeRepository.save(new Employee("Paryut","JanCha"));
			employeeRepository.save(new Employee("Parwit","Watch"));
			employeeRepository.save(new Employee("Parena","Chicken"));
		});
	}

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringApplication.class, args);
	}

}
