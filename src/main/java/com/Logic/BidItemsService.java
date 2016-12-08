package com.Logic;

import java.util.List;

import com.DAO.Bid_ItemsDAO;
import com.DAO.USER_IDDAO;
import com.bean.Bid_ItemsBean;
import com.bean.Sell_ItemsBean;
import com.bean.USER_IDBean;

public class BidItemsService {

	private static Bid_ItemsDAO biddao;
	
	
	public BidItemsService() {
		// TODO Auto-generated constructor stub
		biddao = new Bid_ItemsDAO();
	}

	    
    public void persist(Bid_ItemsBean entity ) {

    	biddao.openCurrentSessionwithTransaction();
    	biddao.persist(entity);	 
    	biddao.closeCurrentSessionwithTransaction();

    }

    public void update(Bid_ItemsBean entity) {

    	biddao.openCurrentSessionwithTransaction();	
    	biddao.update(entity);
    	biddao.closeCurrentSessionwithTransaction();

    }

    
    public List<Bid_ItemsBean> findByItem_sold(Sell_ItemsBean UID) {       
    	
    	biddao.openCurrentSession();	 
    	List<Bid_ItemsBean> Bidders = biddao.findByItems(UID);
        biddao.closeCurrentSession();	 
        return Bidders;
	     }
    
    public List<Bid_ItemsBean> findByBidder(USER_IDBean UID) {       
    	
    	biddao.openCurrentSession();	 
    	List<Bid_ItemsBean> cartitems = biddao.findByBidder(UID);
        biddao.closeCurrentSession();	 
        return cartitems;
	     }
    
public Bid_ItemsBean findByBidderItem(USER_IDBean UID , Sell_ItemsBean SID) {       
    	int i;
    	biddao.openCurrentSession();	 
    	List<Bid_ItemsBean> bidItems = biddao.findByBidder(UID);
    	for(i=0;i<bidItems.size();i++)
        {
       	 if(UID.getUSERID() == bidItems.get(i).getbidder().getUSERID())
       	 break;
        }
        biddao.closeCurrentSession();	 
        return bidItems.get(i);
	   }
    
    
    public Bid_ItemsBean findByBidID(int id) {

    	biddao.openCurrentSession();	 
    	Bid_ItemsBean User = biddao.findByBidid(id);
        biddao.closeCurrentSession();	 
        return User;
	     }


    public void delete(Sell_ItemsBean BEAN,USER_IDBean Bidder) {
    	biddao.openCurrentSessionwithTransaction();
     List<Bid_ItemsBean> bidItems = biddao.findByItems(BEAN);
     for(int i=0;i<bidItems.size();i++)
     {
    	 if(Bidder.getUSERID() == bidItems.get(i).getbidder().getUSERID())
    	     biddao.delete(bidItems.get(i));    	 
    	     
     }
   
     biddao.closeCurrentSessionwithTransaction();

    }
    
    
    public void delBidSameItem(Sell_ItemsBean BEAN,USER_IDBean Bidder) {
    	biddao.openCurrentSessionwithTransaction();
     List<Bid_ItemsBean> bidItems = biddao.findByItems(BEAN);
     for(int i=0;i<bidItems.size();i++)
     {
    	 if(Bidder.getUSERID() != bidItems.get(i).getbidder().getUSERID())    		 
    	     biddao.delete(bidItems.get(i));    	 
    	     
     }
   
     biddao.closeCurrentSessionwithTransaction();

    }

    public List<Bid_ItemsBean> findAll() {

    	biddao.openCurrentSession();	 
        List<Bid_ItemsBean> users = biddao.findAll();	 
        biddao.closeCurrentSession();	 
        return users;

    }

 

    public void deleteAll() {

    	biddao.openCurrentSessionwithTransaction();
    	biddao.deleteAll();
    	biddao.closeCurrentSessionwithTransaction();

    }

    public Bid_ItemsDAO Bid_ItemsDAO() {

        return biddao;

    }

}


