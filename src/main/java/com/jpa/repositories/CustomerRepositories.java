package com.jpa.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entities.CustomerEntity;

@Repository
public class CustomerRepositories {
	
	
	private EntityManager entityManager;

	@Transactional
	public void save(CustomerEntity customer) {
		entityManager.persist(customer);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
}
