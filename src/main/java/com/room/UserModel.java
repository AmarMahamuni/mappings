package com.room;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table( name="user")
@SequenceGenerator(name="USER_SEQ", sequenceName="user_sequence")
public class UserModel   {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,  generator="USER_SEQ")
    private long id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="salary")
    private int salary;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    @MapsId
    private Address address;
    
    
    @OneToMany(mappedBy="um" ,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<PhoneNumbers> p_number=new ArrayList<PhoneNumbers>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	public List<PhoneNumbers> getP_number() {
		return p_number;
	}

	public void setP_number(List<PhoneNumbers> p_number) {
		this.p_number = p_number;
	}

	
	public UserModel(long id, String name, int salary, Address address, List<PhoneNumbers> p_number) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.address = address;
		this.p_number = p_number;
	}


    
    
    
}
