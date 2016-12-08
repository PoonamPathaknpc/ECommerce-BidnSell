package com.Interfaces;

import java.io.Serializable;
import java.util.List;

import com.bean.Sell_ItemsBean;
import com.bean.USER_IDBean;

public interface Bid_ItemsDAOInterface <T, Id extends Serializable> {
	
	public void persist(T entity);
    public void update(T entity);
    public T findByBidid(int bid);
    public List<T> findByBidder(USER_IDBean BEAN);
    public List<T> findByItems(Sell_ItemsBean BEAN);   
    public void delete(T entity);
    public List<T> findAll();
    public void deleteAll();

}
