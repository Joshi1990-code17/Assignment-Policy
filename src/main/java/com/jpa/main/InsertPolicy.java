package com.jpa.main;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jpa.entities.PolicyEntity;
import com.jpa.repositories.PolicyRepository;

public class InsertPolicy {

	public static void main(String[] args) {
		
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("application-context.xml");
		PolicyRepository pr = (PolicyRepository) ctxt.getBean("policyRepository");
		
		PolicyEntity policy = new PolicyEntity();
		policy.setPolicynumber("99877652");
		policy.setPolicytype("Auto");
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2019);
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DAY_OF_MONTH, 1);
		Date startdate = c.getTime();
		
		policy.setStartdate(startdate);
		
		Calendar c1 = Calendar.getInstance();
		c1.set(Calendar.YEAR, 2020);
		c1.set(Calendar.MONTH, 4);
		c1.set(Calendar.DAY_OF_MONTH, 1);
		Date enddate = c1.getTime();
		
		policy.setEnddate(enddate);
		
		policy.setPrice("$600");
		
		
		pr.save(policy);
		
		
		
	}
}
