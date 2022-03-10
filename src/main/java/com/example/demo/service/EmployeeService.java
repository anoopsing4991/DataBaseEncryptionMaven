package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.request.EmployeeRequest;
import com.example.demo.request.EmployeeRequest.AddressRequest;
import com.example.demo.response.EmployeeResponse;

@Service
public class EmployeeService {
    
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	private static Logger _log=LoggerFactory.getLogger(EmployeeService.class);
	
	public EmployeeResponse addEmployee(EmployeeRequest empRequest) {
		
		
	//	Employee e=employeeRepository.save(convertToEmployee(empRequest));
		_log.info("CreateEmployeeRequest {}");
		EmployeeResponse res=new EmployeeResponse();
		try {
			Employee employee=new Employee();
			employee.setName(empRequest.getName());
			employee.setSalary(empRequest.getSalary());
			employee.setCreatedBy(empRequest.getCreatedBy());
			employee.setModifiedBy(empRequest.getModifiedBy());
		employeeRepository.save(employee);
			
			List<AddressRequest> addrRequest=empRequest.getAddress();
			for(AddressRequest req:addrRequest) {
				Address address=new Address();
				address.setStreet(req.getStreet());
				address.setCity(req.getCity());
				address.setState(req.getState());
				address.setPinCode(req.getPinCode());
				address.setCreatedBy(req.getCreatedBy());
				address.setModifiedBy(req.getCreatedBy());
				address.setEmployee(employee);
				addressRepository.save(address);
			}
			res.setName(employee.getName());
			
		}catch(Exception e) {
			_log.error("NOt able to persist request for Employee {} Exception",empRequest,e);
		}
		
		
		return res;
	}
	
	/*
	 * public static Employee convertToEmployee(EmployeeRequest empRequest) {
	 * 
	 * Employee e=new Employee(); e.setName(empRequest.getName());
	 * e.setSalary(empRequest.getSalary()); e.setCreatedBy(empRequest.getName());
	 * e.setModifiedBy(empRequest.getName());
	 * 
	 * return e; }
	 */
}
