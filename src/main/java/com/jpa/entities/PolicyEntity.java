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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "policy")
public class PolicyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "policy_id")
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
	private CustomerEntity customer;

	@OneToMany(mappedBy = "policy",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<CoveredDriversEntity> coveredDrivers;

	@OneToMany(mappedBy = "policy",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CoveredVehiclesEntity> coveredVehicles;

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

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public List<CoveredDriversEntity> getCoveredDrivers() {
		return coveredDrivers;
	}

	public void setCoveredDrivers(List<CoveredDriversEntity> coveredDrivers) {
		this.coveredDrivers = coveredDrivers;
	}

	public List<CoveredVehiclesEntity> getCoveredVehicles() {
		return coveredVehicles;
	}

	public void setCoveredVehicles(List<CoveredVehiclesEntity> coveredVehicles) {
		this.coveredVehicles = coveredVehicles;
	}

	@Override
	public String toString() {
		return "PolicyEntity [policyid=" + policyid + ", policytype=" + policytype + ", policynumber=" + policynumber
				+ ", startdate=" + startdate + ", enddate=" + enddate + ", price=" + price + ", customer=" + customer
				+ ", coveredDrivers=" + coveredDrivers + ", coveredVehicles=" + coveredVehicles + "]";
	}
	
	

}
