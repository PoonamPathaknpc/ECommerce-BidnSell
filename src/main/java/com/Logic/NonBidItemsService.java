package com.Logic;

import java.util.List;
import com.DAO.Bid_ItemsDAO;
import com.DAO.NonBidItemsDAO;
import com.bean.NonBidItemsBean;
import com.bean.Sell_ItemsBean;
import com.bean.USER_IDBean;

public class NonBidItemsService {

	

		private static NonBidItemsDAO nbiddao;
		
		public NonBidItemsService() {
		
			nbiddao = new NonBidItemsDAO();
		}

		    
	    public void persist(NonBidItemsBean entity ) {

	    	nbiddao.openCurrentSessionwithTransaction();
	    	nbiddao.persist(entity);	 
	    	nbiddao.closeCurrentSessionwithTransaction();

	    }

	    public void update(NonBidItemsBean entity) {

	    	nbiddao.openCurrentSessionwithTransaction();	
	    	nbiddao.update(entity);
	    	nbiddao.closeCurrentSessionwithTransaction();

	    }

	    
	    public List<NonBidItemsBean> findByItem_sold(Sell_ItemsBean UID) {       
	    	
	    	nbiddao.openCurrentSession();	 
	    	List<NonBidItemsBean> Bidders = nbiddao.findByItems(UID);
	        nbiddao.closeCurrentSession();	 
	        return Bidders;
		     }
	    
	    public List<NonBidItemsBean> findByBidder(USER_IDBean UID) {       
	    	
	    	nbiddao.openCurrentSession();	 
	    	List<NonBidItemsBean> cartitems = nbiddao.findByBidder(UID);
	        nbiddao.closeCurrentSession();	 
	        return cartitems;
		     }
	    
	    
	    public NonBidItemsBean findByCartID(int id) {

	    	nbiddao.openCurrentSession();	 
	    	NonBidItemsBean User = nbiddao.findByNBidid(id);
	        nbiddao.closeCurrentSession();	 
	        return User;
		     }


	    public void delete(Sell_ItemsBean BEAN) {
	    	nbiddao.openCurrentSessionwithTransaction();
	     List<NonBidItemsBean> nbidItems = nbiddao.findByItems(BEAN);
	     for(int i=0;i<nbidItems.size();i++)
	     {
	    	  nbiddao.delete(nbidItems.get(i));    	 
	    	     
	     }
	   
	     nbiddao.closeCurrentSessionwithTransaction();

	    }

	    public List<NonBidItemsBean> findAll() {

	    	nbiddao.openCurrentSession();	 
	        List<NonBidItemsBean> users = nbiddao.findAll();	 
	        nbiddao.closeCurrentSession();	 
	        return users;

	    }

	    public void deleteAll() {

	    	nbiddao.openCurrentSessionwithTransaction();
	    	nbiddao.deleteAll();
	    	nbiddao.closeCurrentSessionwithTransaction();

	    }

	    public NonBidItemsDAO NonBidItemsDAO() {

	        return nbiddao;

	    }

	}


