package com.jpa.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.jpa.entities.CoveredDriversEntity;
import com.jpa.entities.CoveredVehiclesEntity;

@Repository
public class DriverVehicleRepository {

	private EntityManager entityManager;
	
	public void save(CoveredDriversEntity driver, CoveredVehiclesEntity vehicles) {
		entityManager.persist(driver);
		entityManager.persist(vehicles);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
