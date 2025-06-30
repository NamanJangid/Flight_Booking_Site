package com.flight.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import com.flight.inventory.GenericInventory;

/**
 * 
 * GenericRepository is the generic data access object class for all entities.
 * 
 * @author Naman
 *
 */

@Repository
public class GenericRepository implements GenericInventory {

	@PersistenceContext
	protected EntityManager entityManager;

	public Object save(Object object) {
		Object updatedObject = entityManager.merge(object);
		return updatedObject;
	}

	public <E> E fetch(Class<E> clazz, Object primaryKey) {
		E object = entityManager.find(clazz, primaryKey);
		return object;
	}

}
