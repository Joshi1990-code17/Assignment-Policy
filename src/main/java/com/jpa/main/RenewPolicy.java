package com.jpa.main;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jpa.entities.CoveredDriversEntity;
import com.jpa.entities.CoveredVehiclesEntity;
import com.jpa.entities.PolicyEntity;
import com.jpa.repositories.DriverRepository;
import com.jpa.repositories.PolicyRepository;
import com.jpa.repositories.VehicleRepository;

public class RenewPolicy {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		VehicleRepository vr = (VehicleRepository) context.getBean("vehicleRepository");
		PolicyRepository pr = (PolicyRepository) context.getBean("policyRepository");
		DriverRepository dr = (DriverRepository) context.getBean("driverRepository");

		// 1.Adding a vehicle:
		
		CoveredVehiclesEntity vehicle2 = new CoveredVehiclesEntity();
		vehicle2.setIsactive(true);
		vehicle2.setMake("Toyota");
		vehicle2.setModel("Corolla");
		vehicle2.setVin("r4325ttr4567");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2018);
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DAY_OF_MONTH, 22);
		Date date = c.getTime();
		vehicle2.setYear(date);
		vehicle2.setPolicy(pr.findPolicyById(1));
		vr.addVehicle(vehicle2);

		//Adding a new driver:
		
		CoveredDriversEntity driver2 = new CoveredDriversEntity();
		driver2.setIsactive(true);
		driver2.setName("Roshan");
		driver2.setLicensestate("MD");
		driver2.setLicenseno("B66678789J");
		driver2.setPolicy(pr.findPolicyById(1));
		dr.save(driver2);
		
		
		
		
		
		

	}
}
