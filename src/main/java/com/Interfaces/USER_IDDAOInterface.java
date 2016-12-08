package com.Interfaces;

import java.io.Serializable;
import java.util.List;
import com.bean.USER_INFOBean;

public interface USER_IDDAOInterface <T, Id extends Serializable> {
	
    public void persist(T entity);

    public void update(T entity);

    public T findByUserID(int uid);
    public T findByUinfoEmail(USER_INFOBean BEAN);   
    public void delete(T entity);

    public List<T> findAll();

    public void deleteAll();

}

