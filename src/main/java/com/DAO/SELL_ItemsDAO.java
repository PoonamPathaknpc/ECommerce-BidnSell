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
import com.Interfaces.SELL_ItemsDAOInterface;
import com.bean.Cart_Bean;
import com.bean.NonBidItemsBean;
import com.bean.Sell_ItemsBean;
import com.bean.USER_IDBean;

public class SELL_ItemsDAO implements SELL_ItemsDAOInterface<Sell_ItemsBean, String> {
	 
    private Session currentSession;		 
    private Transaction currentTransaction;

    public SELL_ItemsDAO() {

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

    public void persist(Sell_ItemsBean entity) {
		// TODO Auto-generated method stub
		getCurrentSession().save(entity);
	}

	public void update(Sell_ItemsBean entity) {
		// TODO Auto-generated method stub
		getCurrentSession().update(entity);
		
	}
		
		public Sell_ItemsBean findByItemID(int uid) {
			// TODO Auto-generated method stub
			Sell_ItemsBean bean = (Sell_ItemsBean) getCurrentSession().get(Sell_ItemsBean.class, uid);
			return bean;
		}

		@Override
		public List<Sell_ItemsBean> findBySeller(USER_IDBean SellerBEAN) {
			// TODO Auto-generated method stub
			Query Q =  getCurrentSession().createQuery("from Sell_ItemsBean where Seller = :BEAN");              
	         Q.setEntity("BEAN", SellerBEAN); 
	         List<Sell_ItemsBean> bean = new ArrayList<Sell_ItemsBean>();
	         for(int i=0;i<Q.list().size();i++)
	         {
	        	 bean.add((Sell_ItemsBean)Q.list().get(i));
	         }
	       
	         		
			  return bean;
		}

  
		public void delete(Sell_ItemsBean entity){
		// TODO Auto-generated method stub
		getCurrentSession().delete(entity);	
	   }

    @SuppressWarnings("unchecked")

    public List<Sell_ItemsBean> findAll() {

        List<Sell_ItemsBean> users = (List<Sell_ItemsBean>) getCurrentSession().createQuery("from Sell_ItemsBean").list();		 
        return users;

    }

    public void deleteAll() {

   	 List<Sell_ItemsBean> entityList = findAll();

        for (Sell_ItemsBean entity : entityList) {		 
            delete(entity);

        }

    }

	public List<Sell_ItemsBean> searchItem(String SearchVal) {
		// TODO Auto-generated method stub
		List<Sell_ItemsBean> Itemsearched = new ArrayList<Sell_ItemsBean>();
		System.out.println(SearchVal + " is the search string");
		// Search by Item name 
		 if(getCurrentSession().isConnected())
		{
			 System.out.println("the session is :" + getCurrentSession().toString() );
		Query Q =  getCurrentSession().createQuery("from Sell_ItemsBean where Item_name like :Item");  
		Q.setString("Item", "%" + SearchVal + "%");
		List<?> qlist = Q.list();
		
		if(Q.list().size()!=0)
		{
			for (int i=0;i<qlist.size();i++)
				   Itemsearched.add((Sell_ItemsBean)qlist.get(i));	
		}		
				// Search by Item description
			   
	    Query Q1 = getCurrentSession().createQuery("from USER_INFOBean where Email like :Item");              
		List<?> qlist1 = Q1.setString("Item", "%" + SearchVal + "%").list(); 
				if(Q.list().size()!=0)
				{
					for (int i=0;i<qlist1.size();i++)
					   Itemsearched.add((Sell_ItemsBean)qlist1.get(i));
			    }
		}
		 
		 else
		 System.out.println("session doesnot exist");
		
		return Itemsearched;	
	}

	
}

