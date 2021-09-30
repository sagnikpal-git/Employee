package com.example.Employee.service;

import java.util.List;

import com.example.Employee.model.Employee;

public interface EmployeeService {
	
	/**
	 * @return List of Employee
	 * 
	 */
	List<Employee> getEmployees(); 
	
	/**
	 * @param id
	 * @return Employee
	 * Getting Employee Data
	 */
	Employee getEmployeeById(Long id);
	
	
	/**
	 * @param employee
	 * @return Employee
	 * Adding Employee in Table
	 */
	Employee insert(Employee employee);
	
	
	/**
	 * @param id
	 * @param employee
	 * Modify Employee exist in Table
	 */
	void updateEmployee(Long id, Employee employee);
	
	/**
	 * @param id
	 * Delete Employee from table
	 */
	void deleteEmployee(Long id);

}
