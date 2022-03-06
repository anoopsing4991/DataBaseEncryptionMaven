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
	private Long id;
	@Type(type="encryptedString")
	private String name;
	@Type(type="encryptedDouble")
	private Double salary;
	@Type(type="encryptedLong")
	private Long code;
	@Type(type="encryptedString")
	private String city;
	/*
	 * private String createdBy; private String modifiedBy;
	 * 
	 * @Type(type="encryptedDate") private Date createdOn=new Date();
	 * 
	 * @Type(type="encryptedDate") private Date modifiedOn=new Date();
	 * 
	 * @PreUpdate protected void onUpdate() { modifiedOn = new Date(); }
	 */
}
