package com.springboot.project.service.imp;

import java.util.List;

import com.springboot.project.model.Employee;

public interface EmployeeService {
	
	  Employee saveEmployee(Employee employee);
	  
	  List<Employee> getAllEmployee();
	  
	  Employee getEmployeeById(long id);
	  
	  Employee updateEmployee(Employee employee,long id);
	  
	  void deleteEmployee(long id);
}
