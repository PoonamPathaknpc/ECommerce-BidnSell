package com.Interfaces;

import java.io.Serializable;
import java.util.List;
import com.bean.USER_IDBean;



public interface SELL_ItemsDAOInterface <T, Id extends Serializable> {
	
	public void persist(T entity);
    public void update(T entity);
    public T findByItemID(int uid);
    public List<T> findBySeller(USER_IDBean SellerBEAN); 
    public List<T> searchItem(String SearchVal);
    public void delete(T entity);
    public List<T> findAll();
    public void deleteAll();

}
