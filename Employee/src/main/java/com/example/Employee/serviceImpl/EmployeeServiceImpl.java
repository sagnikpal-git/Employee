package com.example.Employee.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Employee.model.Employee;
import com.example.Employee.repository.EmployeeRepository;
import com.example.Employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepo;
	

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees=new ArrayList<>();
		employeeRepo.findAll().forEach(employees::add);
		return employees;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepo.findById(id).get();
	}

	@Override
	public Employee insert(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public void updateEmployee(Long id, Employee employee) {
		Employee employeeFromDb = employeeRepo.findById(id).get();
        System.out.println("Employee Data to be modify :: "+employeeFromDb.toString());
        employeeFromDb.setDesignation(employee.getDesignation());
        employeeFromDb.setEmailid(employee.getEmailid());
        employeeFromDb.setExperience(employee.getExperience());
        employeeFromDb.setGender(employee.getGender());
        employeeFromDb.setName(employee.getName());
        employeeFromDb.setPhonenumber(employee.getPhonenumber());
        employeeFromDb.setStatus(employee.getStatus());
        employeeRepo.save(employeeFromDb);

	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
	}

}
