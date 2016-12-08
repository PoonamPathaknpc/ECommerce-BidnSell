package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ITEMS_NONBID")
public class NonBidItemsBean {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NONBID_ID")
	private int nbidid;
	
	@OneToOne
	@JoinColumn(name = "ITEM_ID")
	private Sell_ItemsBean Items;
		
	@Column(name ="PRICE")
	private int price;
	
	public NonBidItemsBean() {
		// TODO Auto-generated constructor stub
	}

	public void setbidid(int  nbidid)
	{
		this.nbidid =  nbidid;
	}
	
	
	public void setItem(Sell_ItemsBean sbean)
	{
		this.Items = sbean;
	}

	public void setprice(int cid)
	{
		this.price = cid;
	}
	
	
	
	public int getnbidid()
	{
		return this.nbidid;
		 
	}
	
	public Sell_ItemsBean getItems()
	{
		return this.Items;
	}
	
	
	public int getprice()
	{
		return this.price;
		 
	}

	
}


