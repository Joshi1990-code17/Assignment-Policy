package com.jpa.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entities.CoveredDriversEntity;
import com.jpa.entities.CoveredVehiclesEntity;

@Repository
@Transactional
public class DriverRepository {

	private EntityManager entityManager;
	
	public void save(CoveredDriversEntity driver) {
		entityManager.merge(driver);
		
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
