package com.jpa.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Email")
	private String email;

	@Column(name = "Phone")
	private String phone;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "Last_4_SSN")
	private String last4ssn;

	@Column(name = "Date_Of_Birth")
	private Date dateofbirth;

	@OneToMany(mappedBy = "customer",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<PolicyEntity> policies;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<AddressEntity> address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLast4ssn() {
		return last4ssn;
	}

	public void setLast4ssn(String last4ssn) {
		this.last4ssn = last4ssn;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {

		this.dateofbirth = dateofbirth;
	}

	public List<PolicyEntity> getPolicies() {
		return policies;
	}

	public void setPolicies(List<PolicyEntity> policies) {
		this.policies = policies;
	}

	public List<AddressEntity> getAddress() {
		return address;
	}

	public void setAddress(List<AddressEntity> address) {
		this.address = address;
	}

}
