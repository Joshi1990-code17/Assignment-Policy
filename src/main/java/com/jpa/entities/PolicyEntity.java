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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Policy")
public class PolicyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="policy_id")
	private int policyid;

	@Column(name = "Type")
	private String policytype;

	@Column(name = "PolicyNumber")
	private String policynumber;

	@Column(name = "Start_date")
	private Date startdate;

	@Column(name = "End_date")
	private Date enddate;

	@Column(name = "Price")
	private String price;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "Customer_id")
	private CustomerEntity customerentity;

//	@OneToMany(mappedBy = "policyEntity")
//	private List<CoveredDriversEntity> coveredDriversEntity;
//
//	@OneToMany(mappedBy = "policyEntity")
//	private List<CoveredVehiclesEntity> coveredVehiclesEntity;

	public int getPolicyid() {
		return policyid;
	}

	public void setPolicyid(int policyid) {
		this.policyid = policyid;
	}

	public String getPolicytype() {
		return policytype;
	}

	public void setPolicytype(String policytype) {
		this.policytype = policytype;
	}

	public String getPolicynumber() {
		return policynumber;
	}

	public void setPolicynumber(String policynumber) {
		this.policynumber = policynumber;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public CustomerEntity getCustomerentity() {
		return customerentity;
	}

	public void setCustomerentity(CustomerEntity customerentity) {
		this.customerentity = customerentity;
	}

//	public List<CoveredDriversEntity> getCoveredVehicleEntity() {
//		return coveredDriversEntity;
//	}
//
//	public void setCoveredVehicleEntity(List<CoveredDriversEntity> coveredDriversEntity) {
//		this.coveredDriversEntity = coveredDriversEntity;
//	}
//
//	public List<CoveredVehiclesEntity> getCoveredVehiclesEntity() {
//		return coveredVehiclesEntity;
//	}
//
//	public void setCoveredVehiclesEntity(List<CoveredVehiclesEntity> coveredVehiclesEntity) {
//		this.coveredVehiclesEntity = coveredVehiclesEntity;
//	}

}
