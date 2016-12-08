package com.Logic;

import java.util.List;

import com.DAO.SELL_ItemsDAO;
import com.DAO.USER_IDDAO;
import com.DAO.USER_INFODAO;
import com.bean.Sell_ItemsBean;
import com.bean.USER_IDBean;
import com.bean.USER_INFOBean;

public class Items_SellService {

	
	private static SELL_ItemsDAO SellDao;
	private static USER_IDDAO UID;
	
	public Items_SellService() {
		// TODO Auto-generated constructor stub
		SellDao = new SELL_ItemsDAO();
	}
   
    
    public void persist(Sell_ItemsBean entity) {

    	SellDao.openCurrentSessionwithTransaction();
    	SellDao.persist(entity);	 
    	SellDao.closeCurrentSessionwithTransaction();

    }

    public void update(Sell_ItemsBean entity) {

    	SellDao.openCurrentSessionwithTransaction();	
    	SellDao.update(entity);
    	SellDao.closeCurrentSessionwithTransaction();

    }

    public List<Sell_ItemsBean> findBySeller(USER_IDBean UID) {       
    	
    	SellDao.openCurrentSession();	 
    	List<Sell_ItemsBean> items = SellDao.findBySeller(UID);
        SellDao.closeCurrentSession();	 
        return items;
	     }
    
    public Sell_ItemsBean findByItemId(int id) {

    	SellDao.openCurrentSession();	 
    	Sell_ItemsBean User = SellDao.findByItemID(id);
        SellDao.closeCurrentSession();	 
        return User;
	     }


    public void delete(USER_IDBean UID) {
    	SellDao.openCurrentSessionwithTransaction();

     List<Sell_ItemsBean> items = SellDao.findBySeller(UID);	 
     for(int i=0;i<items.size();i++)
        {    	 		 
    	 SellDao.delete(items.get(i));    	 
    	     
        }     
     SellDao.closeCurrentSessionwithTransaction();

    }

    public void delete(Sell_ItemsBean bean) {
    	SellDao.openCurrentSessionwithTransaction();       	 		 
    	 SellDao.delete(bean);
        SellDao.closeCurrentSessionwithTransaction();

    }
    
    
    
    
    
    public List<Sell_ItemsBean> findAll() {

    	SellDao.openCurrentSession();	 
        List<Sell_ItemsBean> users = SellDao.findAll();	 
        SellDao.closeCurrentSession();	 
        return users;

    }

    public List<Sell_ItemsBean> searchItems(String Val)
    {
    	SellDao.openCurrentSession();
    	List<Sell_ItemsBean> items = SellDao.searchItem(Val);
    	SellDao.closeCurrentSession();	
    	return items;
    }
    
    public void deleteAll() {

    	SellDao.openCurrentSessionwithTransaction();
    	SellDao.deleteAll();
    	SellDao.closeCurrentSessionwithTransaction();

    }

    public SELL_ItemsDAO SELL_ItemsDAO() {

        return SellDao;

    }

}
