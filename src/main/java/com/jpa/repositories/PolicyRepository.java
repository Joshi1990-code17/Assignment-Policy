package com.jpa.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.jpa.entities.PolicyEntity;

@Repository
public class PolicyRepository {

		
	private EntityManager entityManager;
	
	@Transactional
	public void save(PolicyEntity policy) {
		entityManager.merge(policy);
		
		
	}
	
	//finding Policy by PolicyNumber:
	public List<PolicyEntity> findAPolicyByPolicyNo(String PolicyNo) {
		Query query =entityManager.createQuery("select p from PolicyEntity p where p.policynumber = :policyno");
		query.setParameter("policyno", PolicyNo);
		List<PolicyEntity> policyno = (List<PolicyEntity>) query.getResultList();
		
		return policyno;
	}
	
	//Finding policy by Id:
	public PolicyEntity findPolicyById(int policyid) {
		PolicyEntity policyno = entityManager.find(PolicyEntity.class, policyid);
		return policyno;
		
	}
	
	
	

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
}
