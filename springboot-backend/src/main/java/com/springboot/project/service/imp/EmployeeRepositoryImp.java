package com.springboot.project.service.imp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.exception.ResourceNotFoundException;
import com.springboot.project.model.Employee;
import com.springboot.project.service.EmployeeRepository;

@Service
public class EmployeeRepositoryImp implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;

	  public EmployeeRepositoryImp(EmployeeRepository employeeRepository) {
	        super();
	        this.employeeRepository = employeeRepository;
	    }
	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
	@Override
	public Employee getEmployeeById(long id) {
		return employeeRepository.findById(id).orElseThrow( ()->
		new ResourceNotFoundException("Employee" , "Id", id));
	}
	

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow( ()->
			new ResourceNotFoundException("Employee","Id",id));
			existingEmployee.setFirstname(employee.getFirstname());
			existingEmployee.setLastname(employee.getLastname());
			existingEmployee.setEmail(employee.getEmail());
			employeeRepository.save(existingEmployee); 
			return existingEmployee;
			}
	@Override
	public void deleteEmployee(long id) {
		employeeRepository.findById(id).orElseThrow( ()->
		new ResourceNotFoundException("Employee","Id",id));
		employeeRepository.deleteById(id);
	}
		
	}
	

