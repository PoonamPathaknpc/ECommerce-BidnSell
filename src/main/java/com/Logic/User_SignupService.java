package com.Logic;


import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.DAO.USER_INFODAO;
import com.bean.USER_IDBean;
import com.bean.USER_INFOBean;

public class User_SignupService {

	 private static USER_INFODAO UFDao;

	     public User_SignupService() {	
	      UFDao = new USER_INFODAO();	 
	     }
	
	     
	     public void persist(USER_INFOBean entity) {
	 
	     UFDao.openCurrentSessionwithTransaction();
	     UFDao.persist(entity);	 
	     UFDao.closeCurrentSessionwithTransaction();
	
	     }
	
	     public void update(USER_INFOBean entity) {
	
	      UFDao.openCurrentSessionwithTransaction();	
	      UFDao.update(entity);
 	      UFDao.closeCurrentSessionwithTransaction();
	 
	     }
	
	     public USER_INFOBean findByEmail(String Email) {
	 
	         UFDao.openCurrentSession();	 
	         USER_INFOBean User = UFDao.findByEmailID(Email);
	         UFDao.closeCurrentSession();	 
	         return User;
		     }
	 
	     public void delete(String id) {
	       UFDao.openCurrentSessionwithTransaction();
	 
	      USER_INFOBean User = UFDao.findByEmailID(id);	 
	      UFDao.delete(User);
	      UFDao.closeCurrentSessionwithTransaction();
	
	     }
	
	     public List<USER_INFOBean> findAll() {
	 
	         UFDao.openCurrentSession();	 
	         List<USER_INFOBean> users = UFDao.findAll();	 
	         UFDao.closeCurrentSession();	 
	         return users;
	 
	     }
	 
	     public void deleteAll() {
	 
	         UFDao.openCurrentSessionwithTransaction();	 
	         UFDao.deleteAll();	 
	         UFDao.closeCurrentSessionwithTransaction();
	 
	     }
	
	     public USER_INFODAO USERINFODao() {
	 
	         return UFDao;
	 
	     }


}
