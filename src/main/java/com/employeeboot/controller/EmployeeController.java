package com.employeeboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeeboot.dao.EmployeeDao;
import com.employeeboot.dto.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeDao employeeDao;

	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		// @RequestBody-annotated for variable
		// or attribute which we are accepting from a different site
		return employeeDao.saveEmployee(employee);
	}

	@GetMapping
	public Employee findEmployee(@RequestParam int employeeId) {
		return employeeDao.findEmployeeById(employeeId);
	}
	
	@PutMapping//to update/merge
   public Employee updateEmployee(@RequestBody Employee employee,@RequestParam int employeeId)
   {
		return employeeDao.updateEmployeeById(employee, employeeId);
   }
	@DeleteMapping//to delete/remove
	public Employee deleteEmployeeById(@RequestParam int employeeId)
	{
		return employeeDao.deleteEmployeeById(employeeId);
	}
	
}
