package com.room;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Phone_number")
@SequenceGenerator(name="PHONE_SEQ", sequenceName="phone_sequence")
public class PhoneNumbers {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="PRIVATE_SEQ")
	private Long id;

	@Column(name="type")
	private String type;
	

	@Column(name="pnumber")
	private String pnumber;
   


	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonBackReference
	private UserModel um;






	public UserModel getUm() {
		return um;
	}


	public void setUm(UserModel um) {
		this.um = um;
	}


	public PhoneNumbers(Long id, String type, String pnumber, UserModel um) {
		super();
		this.id = id;
		this.type = type;
		this.pnumber = pnumber;
		this.um = um;
	}


	public PhoneNumbers() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getPnumber() {
		return pnumber;
	}


	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}


	public PhoneNumbers(Long id, String type, String pnumber) {
		super();
		this.id = id;
		this.type = type;
		this.pnumber = pnumber;
	}
	
	
	
	
}
