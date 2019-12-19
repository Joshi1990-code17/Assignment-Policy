package com.jpa.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressid;

	@Column(name = "Street1")
	private String street1;

	@Column(name = "Street2")
	private String street2;

	@Column(name = "City")
	private String city;

	@Column(name = "State")
	private String state;

	@Column(name = "Zip")
	private String zip;

	@Column(name = "Type")
	private String type;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private CustomerEntity customerEntity;

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}

}
