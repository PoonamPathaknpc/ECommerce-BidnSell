package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Blob;

@Entity
@Table(name = "IMAGE_TABLE")
public class Image_Bean {
		
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IMGID")
	private int imgid;
	
	@OneToOne
	@JoinColumn(name = "ITEM_ID")
    private Sell_ItemsBean Item;
	
	
	@Column(name ="IMG_NAME")
    private String Imagename;
	
	@Column(name = "IMAGE")
	private String ImageURI;

	public Image_Bean() {
		// TODO Auto-generated constructor stub
	}


	public void setimgid(int cid)
	{
		this.imgid= cid;
	}
	
	public void setItem(Sell_ItemsBean item)
	{
		this.Item = item;
	}
	
	public void setImagename(String imgname)
	{
		this.Imagename = imgname;
	}
	
	
	public void setImageURI(String cid)
	{
		this.ImageURI= cid;
	}
	
	public int getimgid()
	{
		return this.imgid;
		 
	}
	
	public Sell_ItemsBean getItem()
	{
		return this.Item;
	}
	
	public String getImagename()
	{
		return this.Imagename;
		 
	}
	
	public String getImageURI()
	{
		return this.ImageURI;
		 
	}
	
	
}


