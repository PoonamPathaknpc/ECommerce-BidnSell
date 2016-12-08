package com.Logic;

import java.util.Iterator;
import java.util.List;
import com.DAO.Cart_DAO;
import com.DAO.USER_IDDAO;
import com.bean.Cart_Bean;
import com.bean.Sell_ItemsBean;
import com.bean.USER_IDBean;


public class Cart_AddDisplayService {

	private static Cart_DAO cartdao;
	private static USER_IDDAO UID;
	
	public Cart_AddDisplayService() {
		// TODO Auto-generated constructor stub
		cartdao = new Cart_DAO();
	}

	    
    public void persist(Cart_Bean entity ) {

    	cartdao.openCurrentSessionwithTransaction();
    	cartdao.persist(entity);	 
    	cartdao.closeCurrentSessionwithTransaction();

    }

    public void update(Cart_Bean entity) {

    	cartdao.openCurrentSessionwithTransaction();	
    	cartdao.update(entity);
    	cartdao.closeCurrentSessionwithTransaction();

    }

    
    public Cart_Bean findByItem_sold(Sell_ItemsBean UID) {       
    	
    	cartdao.openCurrentSession();	 
    	Cart_Bean User = cartdao.findByItem_sold(UID);
        cartdao.closeCurrentSession();	 
        return User;
	     }
    
    public List<Cart_Bean> findByUser(USER_IDBean UID) {       
    	
    	cartdao.openCurrentSession();	 
    	List<Cart_Bean> cartitems = cartdao.findByUser(UID);
        cartdao.closeCurrentSession();	 
        return cartitems;
	     }
    
    
    public Cart_Bean findByCartID(int id) {

    	cartdao.openCurrentSession();	 
    	Cart_Bean User = cartdao.findByCartID(id);
        cartdao.closeCurrentSession();	 
        return User;
	     }


    public void delete(Sell_ItemsBean BEAN) {
    	cartdao.openCurrentSessionwithTransaction();
     Cart_Bean User = cartdao.findByItem_sold(BEAN);	 
     cartdao.delete(User);
     cartdao.closeCurrentSessionwithTransaction();

    }

    public List<Cart_Bean> findAll() {

    	cartdao.openCurrentSession();	 
        List<Cart_Bean> users = cartdao.findAll();	 
        cartdao.closeCurrentSession();	 
        return users;

    }

 

    public void deleteAll() {

    	cartdao.openCurrentSessionwithTransaction();
    	cartdao.deleteAll();
    	cartdao.closeCurrentSessionwithTransaction();

    }
    
    public void deleteitems(List<Cart_Bean> beans) {

    	cartdao.openCurrentSessionwithTransaction();
    	Iterator<Cart_Bean> it = beans.iterator();
    	while(it.hasNext())
    	{
    		Cart_Bean cb = (Cart_Bean)it.next();
    		cartdao.delete(cb);
    		
    	}
    	cartdao.closeCurrentSessionwithTransaction();

    }


    public Cart_DAO cart_DAO() {

        return cartdao;

    }

}


