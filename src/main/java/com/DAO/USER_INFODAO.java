package com.DAO;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.Interfaces.USER_INFODAOInterface;
import com.bean.USER_INFOBean;


//DAO Class...

public class USER_INFODAO implements USER_INFODAOInterface<USER_INFOBean, String> {
		 
		     private Session currentSession;		 
		     private Transaction currentTransaction;

		     public USER_INFODAO() {
		 
		      }
		 
		  
		
		     public Session openCurrentSession() {		 
		         currentSession = getSessionFactory().openSession();		 
		         return currentSession;		
		     }
		 
		     public Session openCurrentSessionwithTransaction() {
		 
		         currentSession = getSessionFactory().openSession();		 
		         currentTransaction = currentSession.beginTransaction();		 
		         return currentSession;
		     }
		
		     
		     public void closeCurrentSession() {
		 
		         currentSession.close();
		     }
		
		     public void closeCurrentSessionwithTransaction() {
		 
		         currentTransaction.commit();		 
		         currentSession.close();
		      }
		
		     private static SessionFactory getSessionFactory() {
		 
		         Configuration configuration = new Configuration().configure();		 
		         StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
		         applySettings(configuration.getProperties());
		 
		         SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());		 
		         return sessionFactory;
		 
		     }
		
		     public Session getCurrentSession() {
		 
		         return currentSession;
		      }
		 
		     public void setCurrentSession(Session currentSession) {
		
		         this.currentSession = currentSession;
		     }
		
		     public Transaction getCurrentTransaction() {		 
		         return currentTransaction;
		 
		     }
		 
		     public void setCurrentTransaction(Transaction currentTransaction) {		
		         this.currentTransaction = currentTransaction;		
		     }
		
		     public void persist(USER_INFOBean entity) {		 
		         getCurrentSession().save(entity);
		     }
		
		     public void update(USER_INFOBean entity) {
		          getCurrentSession().update(entity);
		      }
		
		     public USER_INFOBean findByEmailID(String Email) {
		 
		      USER_INFOBean book = (USER_INFOBean) getCurrentSession().get(USER_INFOBean.class, Email);
				         return book;
		      }
		 
		     public void delete(USER_INFOBean entity) {		 
		         getCurrentSession().delete(entity);		 
		     }
		
		     @SuppressWarnings("unchecked")
		 
		     public List<USER_INFOBean> findAll() {
		 
		         List<USER_INFOBean> users = (List<USER_INFOBean>) getCurrentSession().createQuery("from USER_INFO").list();		 
		         return users;
		
		     }
	  
		     public void deleteAll() {
		 
		    	 List<USER_INFOBean> entityList = findAll();
		 
		         for (USER_INFOBean entity : entityList) {		 
		             delete(entity);
		 
		         }
		 
		     }
			
	
	
	
}
