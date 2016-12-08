package com.Logic;

import java.util.List;

import com.DAO.USER_IDDAO;
import com.DAO.USER_INFODAO;
import com.bean.USER_IDBean;
import com.bean.USER_INFOBean;


public class User_LoginService {

	
	private static USER_IDDAO UIDDao;
	private static USER_INFODAO UIInfo;
	
	public User_LoginService() {
		UIDDao = new USER_IDDAO();
	}
   
    
    public void persist(USER_IDBean entity) {

    	UIDDao.openCurrentSessionwithTransaction();
    	UIDDao.persist(entity);	 
    	UIDDao.closeCurrentSessionwithTransaction();

    }

    public void update(USER_IDBean entity) {

    	UIDDao.openCurrentSessionwithTransaction();	
    	UIDDao.update(entity);
    	UIDDao.closeCurrentSessionwithTransaction();

    }

    public USER_IDBean findByEmail(USER_INFOBean Bean) {       
    	
    	UIDDao.openCurrentSession();	 
        USER_IDBean User = UIDDao.findByUinfoEmail(Bean);
        UIDDao.closeCurrentSession();	 
        return User;
	     }
    
    public USER_IDBean findByUserid(int id) {

    	UIDDao.openCurrentSession();	 
        USER_IDBean User = UIDDao.findByUserID(id);
        UIDDao.closeCurrentSession();	 
        return User;
	     }


    public void delete(int id) {
    	UIDDao.openCurrentSessionwithTransaction();
     USER_IDBean User = UIDDao.findByUserID(id);	 
     UIDDao.delete(User);
     UIDDao.closeCurrentSessionwithTransaction();

    }

    public List<USER_IDBean> findAll() {

    	UIDDao.openCurrentSession();	 
        List<USER_IDBean> users = UIDDao.findAll();	 
        UIDDao.closeCurrentSession();	 
        return users;

    }

 

    public void deleteAll() {

    	UIDDao.openCurrentSessionwithTransaction();
    	UIDDao.deleteAll();
    	UIDDao.closeCurrentSessionwithTransaction();

    }

    public USER_IDDAO USERINFODao() {

        return UIDDao;

    }


}
