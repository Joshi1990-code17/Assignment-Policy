package com.jpa.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entities.CoveredVehiclesEntity;
import com.jpa.entities.PolicyEntity;

@Repository
@Transactional
public class VehicleRepository {

	private EntityManager entityManager;

	public void addVehicle(CoveredVehiclesEntity vehicle) {
		entityManager.merge(vehicle);

	}

	public PolicyEntity getPolicyByVin(String vin) {
		Query query = entityManager.createQuery("Select c from CoveredVehicleEntity c where c.vin= :vin");
		query.setParameter("vin", vin);
		PolicyEntity pe = (PolicyEntity) query.getSingleResult();
		return pe;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
