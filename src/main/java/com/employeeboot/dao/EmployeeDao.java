package com.employeeboot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employeeboot.dto.Employee;
import com.employeeboot.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public Employee saveEmployee(Employee employee)
	{
		return employeeRepo.save(employee);
	}
	public Employee findEmployeeById(int employeeId)
	{
		Optional<Employee>optional=employeeRepo.findById(employeeId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else
		{
			return null;
		}
		
		
		//Optional-it is a generic class present inside java.util
		//package,to avoid exception when the Object is not found we will
		//use this class ,it accepts a<type attribute>.
		
		//isEmpty() and isPresent() =>these are methods present inside Optional
		//class by which we can check if the data is present or not.
		
		//get()=>this will return the Object found.
	}
	
	
	public Employee updateEmployeeById(Employee updateEmployee ,int employeeId)
	{
		Optional<Employee>optional=employeeRepo.findById(employeeId);
		if(optional.isEmpty())
		{
			return null;
		}
		else
		{
			updateEmployee.setEmployeeId(employeeId);
//			employeeRepo.save(employee);
			return employeeRepo.save(updateEmployee);	}
	}
	
	public Employee deleteEmployeeById(int employeeId)
	{
		Optional<Employee> optional=employeeRepo.findById(employeeId);
		if(optional.isEmpty())
		{
			return null;
		}
		else
		{
			Employee employee=optional.get();
			employeeRepo.delete(employee);
			return employee;
		}
	}

}
