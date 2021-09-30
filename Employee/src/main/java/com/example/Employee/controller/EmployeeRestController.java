package com.example.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.model.Employee;
import com.example.Employee.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {
	
	@Autowired
	EmployeeService employeeService;
	
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
    	System.out.println("=============== Inside GET Employee Rest Controller ============== ");
        List<Employee> employees = employeeService.getEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    
    //The function receives a POST request, processes it, creates a new Employee and saves it to the database, and returns a resource link to the created Employee.   
    @PostMapping("/add")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
    	System.out.println("=============== Inside ADD Employee Rest Controller ============== ");
        Employee employee1 = employeeService.insert(employee);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("employee", "/api/employee/" + Long.toString(employee1.getEmployeecode()));
        return new ResponseEntity<>(employee1, httpHeaders, HttpStatus.CREATED);
    }
    
    //The function receives a Patch request, updates the employee with the specified Id and returns the updated employee
    @PatchMapping({"/update/{employeeCode}"})
    public ResponseEntity<Employee> updateEmployee(@PathVariable("employeeCode") Long employeeCode, @RequestBody Employee employee) {
    	System.out.println("=============== Inside Update Employee Rest Controller ============== ");
    	employeeService.updateEmployee(employeeCode, employee);
        return new ResponseEntity<>(employeeService.getEmployeeById(employeeCode), HttpStatus.OK);
    }
    
    //The function receives a DELETE request, deletes the employee with the specified Id.
    @DeleteMapping({"/{employeeCode}"})
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("employeeCode") Long employeeCode) {
    	System.out.println("=============== Inside Delete Employee Rest Controller ============== ");
    	employeeService.deleteEmployee(employeeCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
	
	

}
