package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.jasypt.hibernate5.type.EncryptedDateAsStringType;
import org.jasypt.hibernate5.type.EncryptedDoubleAsStringType;
import org.jasypt.hibernate5.type.EncryptedIntegerAsStringType;
import org.jasypt.hibernate5.type.EncryptedLongAsStringType;
import org.jasypt.hibernate5.type.EncryptedStringType;

import lombok.Data;

@TypeDefs({
    @TypeDef(
            name="encryptedString",
            typeClass= EncryptedStringType.class,
            parameters= {
                    @Parameter(name="encryptorRegisteredName", value="myStringEncryptor")
            }
    ),
    @TypeDef (name="encryptedInteger", typeClass=
     EncryptedIntegerAsStringType.class, parameters= {
     
     @Parameter(name="encryptorRegisteredName", value="myStringEncryptor")
     } ),
    @TypeDef(
            name="encryptedLong",
            typeClass= EncryptedLongAsStringType.class,
            parameters= {
                    @Parameter(name="encryptorRegisteredName", value="myStringEncryptor")
            }
    ),
    @TypeDef(
            name="encryptedDouble",
            typeClass= EncryptedDoubleAsStringType.class,
            parameters= {
                    @Parameter(name="encryptorRegisteredName", value="myStringEncryptor")
            }
    ),
    @TypeDef (name="encryptedDate", typeClass= EncryptedDateAsStringType.class,
     parameters= {
     
     @Parameter(name="encryptorRegisteredName", value="myStringEncryptor")
     } )
})
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
