package com.jpa.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.jpa.entities.PolicyEntity;

@Repository
public class PolicyRepository {

		
	private EntityManager entityManager;
	
	@Transactional
	public void save(PolicyEntity policy) {
		entityManager.persist(policy);
		
		
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
}
