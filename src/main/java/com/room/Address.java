package com.room;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="address")
@SequenceGenerator(name="ADDRESS_SEQ", sequenceName="address_sequence")
public class Address   {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO, generator="ADDRESS_SEQ")
private long id;

@Column(name="city")
private String city;

@Column(name="pincode")
private int pincode;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public int getPincode() {
	return pincode;
}

public void setPincode(int pincode) {
	this.pincode = pincode;
}

public Address() {
	super();
	// TODO Auto-generated constructor stub
}

public Address(long id, String city, int pincode) {
	super();
	this.id = id;
	this.city = city;
	this.pincode = pincode;
}





	

	
}
