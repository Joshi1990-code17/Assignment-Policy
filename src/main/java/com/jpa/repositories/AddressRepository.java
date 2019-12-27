package com.jpa.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entities.AddressEntity;

@Repository
@Transactional
public class AddressRepository {

	private EntityManager entityManager;
	
	public void save(AddressEntity address) {
		entityManager.merge(address);
	}
	

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
}
