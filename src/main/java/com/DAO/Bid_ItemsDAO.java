package com.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.Interfaces.Bid_ItemsDAOInterface;
import com.Interfaces.USER_IDDAOInterface;
import com.bean.Bid_ItemsBean;
import com.bean.Cart_Bean;
import com.bean.Sell_ItemsBean;
import com.bean.USER_IDBean;
import com.bean.USER_INFOBean;

public class Bid_ItemsDAO implements Bid_ItemsDAOInterface<Bid_ItemsBean, String> {
	 
    private Session currentSession;		 
    private Transaction currentTransaction;

    public Bid_ItemsDAO() {

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

    public void persist(Bid_ItemsBean entity) {		 
        getCurrentSession().save(entity);
    }

    public void update(Bid_ItemsBean entity) {
         getCurrentSession().update(entity);
     }

  	    
   public Bid_ItemsBean  findByBidid(int uid) {
			// TODO Auto-generated method stub
	   Bid_ItemsBean bean = (Bid_ItemsBean) getCurrentSession().get(Bid_ItemsBean.class, uid);
			return bean;
		}
		
   
   public List<Bid_ItemsBean> findByBidder(USER_IDBean BEAN) {
		// TODO Auto-generated method stub		    	 
   	
     Query Q =  getCurrentSession().createQuery("from Bid_ItemsBean where bidder = :bidder");              
     Q.setEntity("bidder", BEAN); 
     List<Bid_ItemsBean> bean = new ArrayList<Bid_ItemsBean>();
     for(int i=0;i<Q.list().size();i++)
     {
    	 bean.add((Bid_ItemsBean)Q.list().get(i));
     }
   
	  return bean;
     
	}
   
  
	public List<Bid_ItemsBean> findByItems(Sell_ItemsBean BEAN) {
		// TODO Auto-generated method stub
		Query Q =  getCurrentSession().createQuery("from Bid_ItemsBean where Item = :Item");              
	     Q.setEntity("Item", BEAN); 
	     List<Bid_ItemsBean> bean = new ArrayList<Bid_ItemsBean>() ;
	     for(int i=0;i<Q.list().size();i++)
	     {
	    	 bean.add((Bid_ItemsBean)Q.list().get(i));
	     }
	   
		  return bean;
	}

   
   
    public void delete(Bid_ItemsBean entity) {		 
        getCurrentSession().delete(entity);		 
    }

    @SuppressWarnings("unchecked")

    public List<Bid_ItemsBean> findAll() {

        List<Bid_ItemsBean> users = (List<Bid_ItemsBean>) getCurrentSession().createQuery("from USER_ID").list();		 
        return users;

    }

    public void deleteAll() {

   	 List<Bid_ItemsBean> entityList = findAll();

        for (Bid_ItemsBean entity : entityList) {		 
            delete(entity);

        }

    }



	

}
