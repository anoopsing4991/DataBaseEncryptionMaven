package com.example.demo.entity;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.jasypt.hibernate5.type.EncryptedDateAsStringType;
import org.jasypt.hibernate5.type.EncryptedDoubleAsStringType;
import org.jasypt.hibernate5.type.EncryptedIntegerAsStringType;
import org.jasypt.hibernate5.type.EncryptedLongAsStringType;
import org.jasypt.hibernate5.type.EncryptedStringType;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

	@Type(type="encryptedString")
	private String createdBy;
	@Type(type="encryptedString")
	private String modifiedBy;
	@Type(type="encryptedDate")
	private Date createdOn=new Date();
	@Type(type="encryptedDate")
	private Date modifiedOn=new Date();
	
	  @PreUpdate
	  protected void onUpdate() {
		  modifiedOn = new Date();
	  }
}
