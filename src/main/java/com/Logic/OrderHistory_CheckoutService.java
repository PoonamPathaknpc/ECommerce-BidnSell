package com.Logic;

import java.util.List;

import com.DAO.OrderDAO;
import com.DAO.USER_IDDAO;
import com.bean.Orders_Bean;
import com.bean.Sell_ItemsBean;
import com.bean.USER_IDBean;

public class OrderHistory_CheckoutService {

	private static OrderDAO orderdao;
	private static USER_IDDAO UID;
	
	public OrderHistory_CheckoutService() {
		// TODO Auto-generated constructor stub
		orderdao = new OrderDAO();
	}

	    
    public void persist(Orders_Bean entity ) {

    	orderdao.openCurrentSessionwithTransaction();
    	orderdao.persist(entity);	 
    	orderdao.closeCurrentSessionwithTransaction();

    }

    public void update(Orders_Bean entity) {

    	orderdao.openCurrentSessionwithTransaction();	
    	orderdao.update(entity);
    	orderdao.closeCurrentSessionwithTransaction();

    }

    
    public Orders_Bean findByItem_sold(Sell_ItemsBean UID) {       
    	
    	orderdao.openCurrentSession();	 
    	Orders_Bean User = orderdao.findByItem_sold(UID);
        orderdao.closeCurrentSession();	 
        return User;
	     }
    
    public List<Orders_Bean>  findByUser(USER_IDBean UID) {       
    	
    	orderdao.openCurrentSession();	 
    	List<Orders_Bean> cartitems = orderdao.findByUser(UID);
        orderdao.closeCurrentSession();	 
        return cartitems;
	     }
    
    
    public Orders_Bean findByOrderID(int id) {

    	orderdao.openCurrentSession();	 
    	Orders_Bean User = orderdao.findByOrderID(id);
        orderdao.closeCurrentSession();	 
        return User;
	     }


    public void delete(Sell_ItemsBean BEAN) {
    	orderdao.openCurrentSessionwithTransaction();
     Orders_Bean User = orderdao.findByItem_sold(BEAN);	 
     orderdao.delete(User);
     orderdao.closeCurrentSessionwithTransaction();

    }

    public List<Orders_Bean> findAll() {

    	orderdao.openCurrentSession();	 
        List<Orders_Bean> users = orderdao.findAll();	 
        orderdao.closeCurrentSession();	 
        return users;

    }

 

    public void deleteAll() {

    	orderdao.openCurrentSessionwithTransaction();
    	orderdao.deleteAll();
    	orderdao.closeCurrentSessionwithTransaction();

    }

    public OrderDAO OrderDAO() {

        return orderdao;

    }

}


