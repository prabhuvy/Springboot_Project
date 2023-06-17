package com.employeeboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeboot.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	// JPA repository ->>it is a interface which acts as an repository and
	// provides some inbuilt methods for performing crud operations

	// it accepts the entity class name and primary key which we have selected
}
