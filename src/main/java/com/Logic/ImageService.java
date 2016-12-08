package com.Logic;

import java.util.List;

import com.DAO.ImageDAO;
import com.DAO.SELL_ItemsDAO;
import com.DAO.USER_IDDAO;
import com.bean.Image_Bean;
import com.bean.Sell_ItemsBean;
import com.bean.USER_IDBean;

public class ImageService{

	
	private static ImageDAO ImgDao;
	
	public ImageService() {
		// TODO Auto-generated constructor stub
		ImgDao = new ImageDAO();
	}
   
    
    public void persist(Image_Bean entity) {

    	ImgDao.openCurrentSessionwithTransaction();
    	ImgDao.persist(entity);	 
    	ImgDao.closeCurrentSessionwithTransaction();

    }

    public void update(Image_Bean entity) {

    	ImgDao.openCurrentSessionwithTransaction();	
    	ImgDao.update(entity);
    	ImgDao.closeCurrentSessionwithTransaction();

    }

    public List<Image_Bean> findByItem(Sell_ItemsBean UID) {       
    	
    	ImgDao.openCurrentSession();	 
    	List<Image_Bean> User = ImgDao.findByItem(UID);
        ImgDao.closeCurrentSession();	 
        return User;
	     }
    
    public Image_Bean findByImageId(int id) {

    	ImgDao.openCurrentSession();	 
    	Image_Bean User = ImgDao.findByImgid(id);
        ImgDao.closeCurrentSession();	 
        return User;
	     }

    public List<Image_Bean> findAll() {

    	ImgDao.openCurrentSession();	 
        List<Image_Bean> users = ImgDao.findAll();	 
        ImgDao.closeCurrentSession();	 
        return users;

    }

    public void deleteAll() {

    	ImgDao.openCurrentSessionwithTransaction();
    	ImgDao.deleteAll();
    	ImgDao.closeCurrentSessionwithTransaction();

    }

    public ImageDAO ImageDAO() {

        return ImgDao;

    }

}
