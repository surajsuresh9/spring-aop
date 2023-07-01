package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.entity.Employee;
import com.repo.EmployeeRepo;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Autowired
	EmployeeRepo employeeRepo;

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("Hi");
			if (!employeeRepo.findAll().isEmpty()) {
				for (Employee e : employeeRepo.findAll()) {
					System.out.println(e);
				}
			} else {
				System.out.println("No employees in db");
			}
		};
	}

}
