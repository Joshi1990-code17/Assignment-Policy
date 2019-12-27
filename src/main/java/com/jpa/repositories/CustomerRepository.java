package com.jpa.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entities.CustomerEntity;

@Repository
public class CustomerRepository {

	private EntityManager entityManager;

	@Transactional
	public CustomerEntity save(CustomerEntity customer) {
		return entityManager.merge(customer);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
