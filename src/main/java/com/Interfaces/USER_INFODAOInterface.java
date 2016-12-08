package com.Interfaces;

import java.io.Serializable;
import java.util.List;

public interface USER_INFODAOInterface <T, Id extends Serializable> {
	
	    public void persist(T entity);
	
	    public void update(T entity);

	    public T findByEmailID(String Email);
	
	    public void delete(T entity);
	
	    public List<T> findAll();
	
	    public void deleteAll();
	
	}
