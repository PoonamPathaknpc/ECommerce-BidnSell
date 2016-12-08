package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import com.Interfaces.ImageDAOInterface;
import com.bean.Image_Bean;
import com.bean.Sell_ItemsBean;


public class ImageDAO implements ImageDAOInterface <Image_Bean, String> {
	 
    private Session currentSession;		 
    private Transaction currentTransaction;

    public ImageDAO() {

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

    public void persist(Image_Bean entity) {
			// TODO Auto-generated method stub
			getCurrentSession().save(entity);
			
		}


		public void update(Image_Bean entity) {
			// TODO Auto-generated method stub
			 getCurrentSession().update(entity);
		}


	
		@Override
		public Image_Bean findByImgid(int bid) {
			// TODO Auto-generated method stub
			Image_Bean bean = (Image_Bean) getCurrentSession().get(Image_Bean.class, bid);
			return bean;
		}

		@Override
		public List<Image_Bean> findByItem(Sell_ItemsBean BEAN) {
			// TODO Auto-generated method stub
			Query Q =  getCurrentSession().createQuery("from Image_Bean where Item = :Item");              
	         Q.setEntity("Item", BEAN); 
	         List<Image_Bean> bean = null;
	         for(int i=0;i<Q.list().size();i++)
	         {
	        	 bean.add((Image_Bean)Q.list().get(i));
	         }	
			  return bean;
		}

    public void delete(Image_Bean entity) {
		// TODO Auto-generated method stub
		getCurrentSession().delete(entity);	
	}

    @SuppressWarnings("unchecked")

    public List<Image_Bean> findAll() {

        List<Image_Bean> users = (List<Image_Bean>) getCurrentSession().createQuery("from Image_Bean").list();		 
        return users;

    }

    public void deleteAll() {

   	 List<Image_Bean> entityList = findAll();

        for (Image_Bean entity : entityList) {		 
            delete(entity);

        }

    }

}

