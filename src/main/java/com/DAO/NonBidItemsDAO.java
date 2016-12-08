package com.DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import com.Interfaces.Bid_ItemsDAOInterface;
import com.Interfaces.NonBidItemsDAOInterface;
import com.bean.NonBidItemsBean;
import com.bean.NonBidItemsBean;
import com.bean.Sell_ItemsBean;
import com.bean.USER_IDBean;

public class NonBidItemsDAO implements NonBidItemsDAOInterface<NonBidItemsBean, String> {
	 
    private Session currentSession;		 
    private Transaction currentTransaction;

    public NonBidItemsDAO() {

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

    public void persist(NonBidItemsBean entity) {		 
        getCurrentSession().save(entity);
    }

    public void update(NonBidItemsBean entity) {
         getCurrentSession().update(entity);
     }

    
	public NonBidItemsBean findByNBidid(int nbid) {
		// TODO Auto-generated method stub
		NonBidItemsBean bean = (NonBidItemsBean) getCurrentSession().get(NonBidItemsBean.class, nbid);
		return bean;
	}

   public List<NonBidItemsBean> findByBidder(USER_IDBean BEAN) {
		// TODO Auto-generated method stub		    	 
   	
     Query Q =  getCurrentSession().createQuery("from NonBidItemsBean where bidder = :bidder");              
     Q.setEntity("bidder", BEAN); 
     List<NonBidItemsBean> bean = null;
     for(int i=0;i<Q.list().size();i++)
     {
    	 bean.add((NonBidItemsBean)Q.list().get(i));
     }
   
	  return bean;
     
	}
   
  
	public List<NonBidItemsBean> findByItems(Sell_ItemsBean BEAN) {
		// TODO Auto-generated method stub
		Query Q =  getCurrentSession().createQuery("from NonBidItemsBean where Item = :Item");              
	     Q.setEntity("Item", BEAN); 
	     List<NonBidItemsBean> bean = new ArrayList<NonBidItemsBean>();
	     for(int i=0;i<Q.list().size();i++)
	     {
	    	 bean.add((NonBidItemsBean)Q.list().get(i));
	     }
	   
		  return bean;
	}

   
   
    public void delete(NonBidItemsBean entity) {		 
        getCurrentSession().delete(entity);		 
    }

    @SuppressWarnings("unchecked")

    public List<NonBidItemsBean> findAll() {

        List<NonBidItemsBean> users = (List<NonBidItemsBean>) getCurrentSession().createQuery("from USER_ID").list();		 
        return users;

    }

    public void deleteAll() {

   	 List<NonBidItemsBean> entityList = findAll();

        for (NonBidItemsBean entity : entityList) {		 
            delete(entity);

        }

    }


}
