package com.jpa.main;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jpa.entities.CustomerEntity;
import com.jpa.repositories.CustomerRepositories;

public class InsertCustomerMain {
	
	public static void main(String[] args) {
		
	ApplicationContext ctxt = new ClassPathXmlApplicationContext("application-context.xml");
	CustomerRepositories cr = (CustomerRepositories) ctxt.getBean("customerRepositories");
	
		CustomerEntity customer1 = new CustomerEntity();
		customer1.setName("Jay Joshi");
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 1990);
		c.set(Calendar.MONTH, 7);
		c.set(Calendar.DAY_OF_MONTH, 17);
		Date date = c.getTime();
		customer1.setDateofbirth(date);
		customer1.setEmail("jay@mail.com");
		customer1.setGender("Male");
		customer1.setPhone("5717894367");
		customer1.setLast4ssn("1234");
		
		cr.save(customer1);
	}
	

	
}