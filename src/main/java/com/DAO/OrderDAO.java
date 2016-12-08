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
import com.Interfaces.OrderDAOInterface;
import com.bean.Orders_Bean;
import com.bean.Orders_Bean;
import com.bean.Sell_ItemsBean;
import com.bean.USER_IDBean;

public class OrderDAO implements OrderDAOInterface <Orders_Bean, String> {
	 
    private Session currentSession;		 
    private Transaction currentTransaction;

    public OrderDAO() {

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

    public void persist(Orders_Bean entity) {
			// TODO Auto-generated method stub
			getCurrentSession().save(entity);
			
		}


		public void update(Orders_Bean entity) {
			// TODO Auto-generated method stub
			 getCurrentSession().update(entity);
		}


		public Orders_Bean findByOrderID(int uid) {
			// TODO Auto-generated method stub
			Orders_Bean bean = (Orders_Bean) getCurrentSession().get(Orders_Bean.class, uid);
			return bean;
		}

		
	

		public List<Orders_Bean> findByUser(USER_IDBean BEAN) {
			// TODO Auto-generated method stub
			Query Q =  getCurrentSession().createQuery("from Orders_Bean where user = :BEAN");              
	         Q.setEntity("BEAN", BEAN); 
	         List<Orders_Bean> bean = new ArrayList<Orders_Bean>();
	         for(int i=0;i<Q.list().size();i++)
	         {
	        	 bean.add((Orders_Bean)Q.list().get(i));
	         }
	       
			  return bean;
		}


		public Orders_Bean findByItem_sold(Sell_ItemsBean BEAN) {
			// TODO Auto-generated method stub
			Query Q =  getCurrentSession().createQuery("from Orders_Bean where Items_Sell = :BEAN");              
	         Q.setEntity("BEAN", BEAN); 
	         List list = Q.list();
	         System.out.println(list.get(0));
	         Orders_Bean bean = (Orders_Bean)list.get(0);				
			  return bean;
		}


  
    public void delete(Orders_Bean entity) {
		// TODO Auto-generated method stub
		getCurrentSession().delete(entity);	
	}

    @SuppressWarnings("unchecked")

    public List<Orders_Bean> findAll() {

        List<Orders_Bean> users = (List<Orders_Bean>) getCurrentSession().createQuery("from Orders_Bean").list();		 
        return users;

    }

    public void deleteAll() {

   	 List<Orders_Bean> entityList = findAll();

        for (Orders_Bean entity : entityList) {		 
            delete(entity);

        }

    }

	
}

