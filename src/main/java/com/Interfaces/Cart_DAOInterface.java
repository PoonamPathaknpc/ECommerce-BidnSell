package com.Interfaces;

import java.io.Serializable;
import java.util.List;

import com.bean.Sell_ItemsBean;
import com.bean.USER_IDBean;

public interface Cart_DAOInterface <T, Id extends Serializable> {
	
	public void persist(T entity);
    public void update(T entity);
    public T findByCartID(int uid);
    public T findByItem_sold(Sell_ItemsBean BEAN);   
    public List<T> findByUser(USER_IDBean BEAN); 
    public void delete(T entity);
    public List<T> findAll();
    public void deleteAll();

}
