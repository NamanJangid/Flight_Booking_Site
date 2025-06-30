package com.flight.inventory;

/**
 * 
 * GenericInventory interface an inventory for the GenericRepository class.
 * 
 * @author Naman
 *
 */

public interface GenericInventory {

	public Object save(Object object);
	public <E> E fetch(Class<E> clazz, Object pk);
	
}
