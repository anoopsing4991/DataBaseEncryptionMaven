package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity

public class Employee extends BaseEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Type(type="encryptedLong")
	private Long id;
	
	@Type(type="encryptedString")
	private String name;
	
	@Type(type="encryptedDouble")
	private Double salary;
	
}
