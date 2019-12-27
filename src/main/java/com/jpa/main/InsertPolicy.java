package com.jpa.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jpa.entities.AddressEntity;
import com.jpa.entities.CoveredDriversEntity;
import com.jpa.entities.CoveredVehiclesEntity;
import com.jpa.entities.CustomerEntity;
import com.jpa.entities.PolicyEntity;
import com.jpa.repositories.AddressRepository;
import com.jpa.repositories.CustomerRepository;
import com.jpa.repositories.DriverRepository;
import com.jpa.repositories.PolicyRepository;
import com.jpa.repositories.VehicleRepository;

public class InsertPolicy {

	public static void main(String[] args) {

		ApplicationContext ctxt = new ClassPathXmlApplicationContext("application-context.xml");
		PolicyRepository pr = (PolicyRepository) ctxt.getBean("policyRepository");
		DriverRepository dr = (DriverRepository) ctxt.getBean("driverRepository");
		VehicleRepository veh = (VehicleRepository) ctxt.getBean("vehicleRepository");
		AddressRepository ar = (AddressRepository) ctxt.getBean("addressRepository");
		CustomerRepository cr = (CustomerRepository) ctxt.getBean("customerRepository");

		CustomerEntity customer1 = new CustomerEntity();
		customer1.setName("Jay Joshi");

		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 1991);
		c.set(Calendar.MONTH, 7);
		c.set(Calendar.DAY_OF_MONTH, 17);
		Date date = c.getTime();
		customer1.setDateofbirth(date);
		customer1.setEmail("jay@mail.com");
		customer1.setGender("Male");
		customer1.setPhone("5717894367");
		customer1.setLast4ssn("1234");
		customer1 = cr.save(customer1);

		// address 1

		AddressEntity ae1 = new AddressEntity();
		ae1.setStreet1("Mason Drive");
		ae1.setStreet2("3025 VA dare Ct");
		ae1.setType("Home");
		ae1.setZip("20150");
		ae1.setCity("Chantilly");
		ae1.setState("Virginia");
		ae1.setCustomer(customer1);

		// address2:

		AddressEntity ae2 = new AddressEntity();
		ae2.setStreet1("Tysons Corner");
		ae2.setStreet2("1500 Cornerside Blvd");
		ae2.setZip("20090");
		ae2.setType("Work");
		ae2.setCity("Vienna");
		ae2.setState("VA");
		ae2.setCustomer(customer1);

		System.out.println("inserting address 1");
		ar.save(ae1);
		System.out.println("inserting address 2");
		ar.save(ae2);

		// adding policy
		PolicyEntity policy = new PolicyEntity();
		policy.setPolicynumber("99877652");
		policy.setPolicytype("Auto");

		Calendar c3 = Calendar.getInstance();
		c3.set(Calendar.YEAR, 2019);
		c3.set(Calendar.MONTH, 11);
		c3.set(Calendar.DAY_OF_MONTH, 1);
		Date startdate = c3.getTime();

		policy.setStartdate(startdate);

		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 2020);
		c1.set(Calendar.MONTH, 4);
		c1.set(Calendar.DAY_OF_MONTH, 1);
		Date enddate = c1.getTime();

		policy.setEnddate(enddate);

		policy.setPrice("$600");
		policy.setCustomer(customer1);
		pr.save(policy);

		// Adding Covered Vehicle

		List<CoveredVehiclesEntity> vehicles = new ArrayList<CoveredVehiclesEntity>();
		CoveredVehiclesEntity vehicle = new CoveredVehiclesEntity();
		vehicle.setIsactive(true);
		vehicle.setMake("Toyota");
		vehicle.setModel("Tacoma");
		vehicle.setVin("AB12434567yT8");

		Calendar cc = Calendar.getInstance();
		cc.set(Calendar.YEAR, 2018);
		cc.set(Calendar.MONTH, 11);
		cc.set(Calendar.DAY_OF_MONTH, 11);

		Date date1 = cc.getTime();

		vehicle.setYear(date1);

		vehicle.setPolicy(policy);
		veh.addVehicle(vehicle);

		// adding driver
		CoveredDriversEntity driver = new CoveredDriversEntity();
		driver.setIsactive(true);
		driver.setLicenseno("B123456689");
		driver.setLicensestate("VA");
		driver.setName("Kishor");
		driver.setPolicy(policy);
		dr.save(driver);

		System.out.println("Adding Policy");

		System.out.println("Done");
		System.out.println(policy.toString());

	}
}
