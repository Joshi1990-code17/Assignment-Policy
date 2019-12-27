package com.jpa.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jpa.entities.PolicyEntity;
import com.jpa.repositories.PolicyRepository;
import com.jpa.repositories.VehicleRepository;

public class FindPolicyByVin {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		VehicleRepository vr = (VehicleRepository) context.getBean("vehicleRepository");
		PolicyRepository pr = (PolicyRepository) context.getBean("policyRepository");

		// Finding the policy by Vin Number:
		PolicyEntity pe = vr.getPolicyByVin("r4325ttr4567");
		System.out.println(pe.toString());
	}
}