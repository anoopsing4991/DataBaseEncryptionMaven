package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeResponse {
	@JsonProperty(value = "emp_name")
	private String name;
	private String city;
	private String street;
	private String state;
	private Integer pinCode;

}
