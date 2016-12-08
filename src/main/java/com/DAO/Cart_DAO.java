package com.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.Interfaces.Cart_DAOInterface;
import com.Interfaces.USER_IDDAOInterface;
import com.bean.USER_IDBean;
import com.bean.Bid_ItemsBean;
import com.bean.Cart_Bean;
import com.bean.Sell_ItemsBean;;



public class Cart_DAO implements Cart_DAOInterface <Cart_Bean, String> {
		 
	     private Session currentSession;		 
	     private Transaction currentTransaction;

	     public Cart_DAO() {
	 
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
	
	     public void persist(Cart_Bean entity) {
				// TODO Auto-generated method stub
				getCurrentSession().save(entity);
				
			}


			public void update(Cart_Bean entity) {
				// TODO Auto-generated method stub
				 getCurrentSession().update(entity);
			}
	

			
			public Cart_Bean findByCartID(int uid) {
				// TODO Auto-generated method stub
				Cart_Bean bean = (Cart_Bean) getCurrentSession().get(Cart_Bean.class, uid);
				return bean;
				
			}

			

			public List<Cart_Bean> findByUser(USER_IDBean BEAN) {
				// TODO Auto-generated method stub
				Query Q =  getCurrentSession().createQuery("from Cart_Bean where user = :BEAN");              
		         Q.setEntity("BEAN", BEAN); 
		         List<Cart_Bean> bean = new ArrayList<Cart_Bean>();
		         for(int i=0;i<Q.list().size();i++)
		         {
		        	 bean.add((Cart_Bean)Q.list().get(i));
		         }
		       
				  return bean;
			}

	
			public Cart_Bean findByItem_sold(Sell_ItemsBean BEAN) {
				// TODO Auto-generated method stub
				Query Q =  getCurrentSession().createQuery("from Cart_Bean where Items_Sell = :BEAN");              
		         Q.setEntity("BEAN", BEAN); 
		         List list = Q.list();
		         System.out.println(list.get(0));
		         Cart_Bean bean = (Cart_Bean)list.get(0);				
				  return bean;
			}

 	
	   
	     public void delete(Cart_Bean entity) {
			// TODO Auto-generated method stub
			getCurrentSession().delete(entity);	
		}

	     @SuppressWarnings("unchecked")
	 
	     public List<Cart_Bean> findAll() {
	 
	         List<Cart_Bean> users = (List<Cart_Bean>) getCurrentSession().createQuery("from Cart_Bean").list();		 
	         return users;
	
	     }
 
	     public void deleteAll() {
	 
	    	 List<Cart_Bean> entityList = findAll();
	 
	         for (Cart_Bean entity : entityList) {		 
	             delete(entity);
	 
	         }
	 
	     }

		

}

