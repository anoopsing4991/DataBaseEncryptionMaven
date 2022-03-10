package com.example.demo.request;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"name","city","salary","address"})
@Data
public class EmployeeRequest {
	
	//@JsonProperty(value = "name")
	private String name;
	private Double salary;
	private String createdBy;
	private String modifiedBy;
    private List<AddressRequest> address=new ArrayList<AddressRequest>();
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPropertyOrder({"street","city","state","pinCode"})
    @Data
    public static class AddressRequest{
   	 private String street;
   	 private String city;
   	 private String state;
   	 private Integer pinCode;
   	private String createdBy;
	private String modifiedBy;
   }
}
