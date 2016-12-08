package com.Interfaces;

import java.io.Serializable;
import java.util.List;
import com.bean.Sell_ItemsBean;


public interface ImageDAOInterface <T, Id extends Serializable> {
	
	public void persist(T entity);
    public void update(T entity);
    public T findByImgid(int bid);
    public List<T> findByItem(Sell_ItemsBean BEAN);      
    public void delete(T entity);
    public List<T> findAll();
    public void deleteAll();

}