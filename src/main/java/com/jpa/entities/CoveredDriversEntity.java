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
@Table(name="Covered_Driver")
public class CoveredDriversEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="LicenseNo")
	private String licenseno;
	
	@Column(name="LicensedState")
	private String licensestate;
	
	@Column(name="is_active")
	private boolean isactive;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="policy_id")
	private PolicyEntity policyEntity;

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

	public String getLicenseno() {
		return licenseno;
	}

	public void setLicenseno(String licenseno) {
		this.licenseno = licenseno;
	}

	public String getLicensestate() {
		return licensestate;
	}

	public void setLicensestate(String licensestate) {
		this.licensestate = licensestate;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public PolicyEntity getPolicyEntity() {
		return policyEntity;
	}

	public void setPolicyEntity(PolicyEntity policyEntity) {
		this.policyEntity = policyEntity;
	}
	
	
}



