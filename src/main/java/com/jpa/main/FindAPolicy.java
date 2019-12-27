package com.jpa.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jpa.entities.PolicyEntity;
import com.jpa.repositories.PolicyRepository;

public class FindAPolicy {
	
	public static void main(String[] args) {
		
		//Finding a PolicyEntity by PolicyNumber
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		PolicyRepository pr = (PolicyRepository) context.getBean("policyRepository");
		//List<PolicyEntity> p = pr.findAPolicyByPolicyNo("99877652");
		
		
		
//		for(PolicyEntity pee : p) {
//			System.out.println(p);
//		}
		
		//Finding a policyEntity by PolicyId
		PolicyEntity pe = pr.findPolicyById(1);
		System.out.println(pe.toString());
	}

}
