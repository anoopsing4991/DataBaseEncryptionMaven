package com.example.demo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.jasypt.hibernate5.type.EncryptedDateAsStringType;
import org.jasypt.hibernate5.type.EncryptedIntegerAsStringType;
import org.jasypt.hibernate5.type.EncryptedStringType;

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
    @TypeDef (name="encryptedDate", typeClass= EncryptedDateAsStringType.class,
     parameters= {
     
     @Parameter(name="encryptorRegisteredName", value="myStringEncryptor")
     } )
})

@Entity (name = "creditcard")
public class CreditCard {
@Id
@GeneratedValue
private Long id;
@Type(type="encryptedString")
private String name;
@Type(type="encryptedString")
private String number;
@Type(type="encryptedInteger")
private Integer cvv;
@Type(type="encryptedDate")
private Date validFrom=new Date();
private Date validTo=new Date();


@Type(type="encryptedString")
public String getNumber() {
  return number;
}

public void setNumber(String number) {
  this.number = number;
}

@Type(type="encryptedString")
public Integer getCvv() {
  return cvv;
}

public void setCvv(Integer cvv) {
  this.cvv = cvv;
}

//@Type(type="encryptedDate")
public Date getValidTo() {
  return validTo;
}

public void setValidTo(Date validTo) {
  this.validTo = validTo;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}
@Type(type="encryptedString")
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
@Type(type="encryptedDate")
public Date getValidFrom() {
	return validFrom;
}

public void setValidFrom(Date validFrom) {
	this.validFrom = validFrom;
}
}
