package com.springboot.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.project.model.Employee;
import com.springboot.project.service.imp.EmployeeService;


@RestController
@RequestMapping("/api/employeee")
public class EmployeeController {
	
	//DI
    private EmployeeService employeeService;
   
   //Constructor
    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }
    
    //Build create employee REST API
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),
                HttpStatus.CREATED);
}
    @GetMapping
    public List<Employee> getAllEmployee(){
    	return employeeService.getAllEmployee();
    	}
    @GetMapping("{id}")
    public ResponseEntity<Employee>  getEmployeeById(@PathVariable ("id") long employeeId){
		return new ResponseEntity<Employee> (employeeService.getEmployeeById(employeeId),
				HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee ){
        return new ResponseEntity<Employee>
        (employeeService.updateEmployee(employee,id),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmplpoyee(@PathVariable ("id") long id){
    	
    	employeeService.deleteEmployee(id);
    	return new ResponseEntity<String>("Employee data deleted successfully" ,HttpStatus.OK);
    }
    
}
