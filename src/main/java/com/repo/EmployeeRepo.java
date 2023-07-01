package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
