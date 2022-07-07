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
import com.example.demo.request.EmployeeRequest;
import com.example.demo.response.EmployeeResponse;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeService employeeService;
	@PostMapping("/")
	public EmployeeResponse saveEmployee(@RequestBody EmployeeRequest request) {
		return employeeService.addEmployee(request);
		
	}
	
	@PutMapping("/{id}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id) {
		Employee e=employeeRepository.getById(id);
		e.setName(employee.getName());
		employeeRepository.save(e);
		
	}
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable("id") Long id) {
		Employee e=employeeRepository.findById(id).get();
		 return e;
	}

	@GetMapping("name/{name}")
	public List<Employee> getEmployeeByName(@PathVariable("name") String name) {
		List<Employee> e=employeeRepository.findByCreatedBy(name);
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
