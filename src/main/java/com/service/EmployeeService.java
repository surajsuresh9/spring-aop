package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Employee;
import com.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	public Employee save(Employee employee) throws Exception {
		if (employee.getName().length() > 5) {
			throw new Exception("Name is too long");
		}
		return employeeRepo.save(employee);
	}
}
