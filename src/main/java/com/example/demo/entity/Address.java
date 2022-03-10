package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Data
@Table
public class Address extends BaseEntity{


	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
//	 @Type(type="encryptedLong")
	 private Long id;
	 
	 @Type(type="encryptedString")
	 private String street;
	 @Type(type="encryptedString")
	 private String city;
	 @Type(type="encryptedString")
	 private String state;
	 @Type(type="encryptedInteger")
	 private Integer pinCode;
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name="emp_id",referencedColumnName ="id" )
	 @Type(type="encryptedLong")
	 private Employee employee;

}
