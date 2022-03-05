package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/")
	public void saveEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		
	}
	
	@PutMapping("/{id}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id) {
		Employee e=employeeRepository.getById(id);
		e.setCode(employee.getCode());
		employeeRepository.save(e);
		
	}
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable("id") Long id) {
		Employee e=employeeRepository.findById(id).get();
		System.out.println(e.toString());
		 return e;
	}

	@GetMapping("name/{name}")
	public List<Employee> getEmployeeByName(@PathVariable("name") Double name) {
		List<Employee> e=employeeRepository.findBySalary(name);
		System.out.println(e.toString());
		 return e;
	}
	
	@GetMapping("/all")
	public List<Employee> getAllEmployee(){
			List<Employee> e=null;
			e=employeeRepository.findAll();
			e.forEach(System.out::println);
			return e;
			
		}
	

	

}
