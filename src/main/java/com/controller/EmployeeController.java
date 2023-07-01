package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Employee;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	com.service.EmployeeService employeeService;

	@GetMapping("/")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) throws Exception {
		return employeeService.save(employee);
	}
}
