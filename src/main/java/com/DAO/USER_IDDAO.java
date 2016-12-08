package com.DAO;


import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import com.Interfaces.USER_IDDAOInterface;
import com.bean.USER_IDBean;
import com.bean.USER_INFOBean;


//DAO Class...

public class USER_IDDAO implements USER_IDDAOInterface<USER_IDBean, String> {
		 
		     private Session currentSession;		 
		     private Transaction currentTransaction;

		     public USER_IDDAO() {
		 
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
		
		     public void persist(USER_IDBean entity) {		 
		         getCurrentSession().save(entity);
		     }
		
		     public void update(USER_IDBean entity) {
		          getCurrentSession().update(entity);
		      }
		
		   	    
		    public USER_IDBean findByUserID(int uid) {
					// TODO Auto-generated method stub
					USER_IDBean bean = (USER_IDBean) getCurrentSession().get(USER_IDBean.class, uid);
					return bean;
				}
				
		    
		    public USER_IDBean findByUinfoEmail(USER_INFOBean Uinfo) {
				// TODO Auto-generated method stub		    	 
		    	
              Query Q =  getCurrentSession().createQuery("from USER_IDBean where Uinfo = :Uinfo");              
              Q.setEntity("Uinfo", Uinfo); 
              List list = Q.list();
              System.out.println(list.get(0));
              USER_IDBean bean = (USER_IDBean)list.get(0);				
			  return bean;
			}
		    
		     public void delete(USER_IDBean entity) {		 
		         getCurrentSession().delete(entity);		 
		     }
		
		     @SuppressWarnings("unchecked")
		 
		     public List<USER_IDBean> findAll() {
		 
		         List<USER_IDBean> users = (List<USER_IDBean>) getCurrentSession().createQuery("from USER_ID").list();		 
		         return users;
		
		     }
	  
		     public void deleteAll() {
		 
		    	 List<USER_IDBean> entityList = findAll();
		 
		         for (USER_IDBean entity : entityList) {		 
		             delete(entity);
		 
		         }
		 
		     }



			
	
	
	
}
