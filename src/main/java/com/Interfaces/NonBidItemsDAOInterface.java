package com.Interfaces;

import java.io.Serializable;
import java.util.List;
import com.bean.Sell_ItemsBean;
import com.bean.USER_IDBean;

public interface NonBidItemsDAOInterface <T, Id extends Serializable> {
	
	public void persist(T entity);
    public void update(T entity);
    public T findByNBidid(int nbid);
    public List<T> findByItems(Sell_ItemsBean BEAN);   
    public void delete(T entity);
    public List<T> findAll();
    public void deleteAll();

}
