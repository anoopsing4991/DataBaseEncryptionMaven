package com.example.demo;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author vikram.choudhary 27/05/20
 */

@Data
@Entity
@Table(name = "CARD_DETAIL")
@NoArgsConstructor
@AllArgsConstructor
public class CardDetail {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@Convert(converter = StringAttributeConverter.class)
	private String number;
	private String expiry;

}
