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
@Table(name = "ITEMS_BID")
public class Bid_ItemsBean {
    
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BID_ID")
	private int bidid;
	
	@OneToOne
	@JoinColumn(name = "BIDDER_ID")
	private USER_IDBean bidder;
	
	@OneToOne
	@JoinColumn(name = "ITEM_ID")
	private Sell_ItemsBean Item;

	@Column(name ="BID_VALUE")
	private int bidvalue;
	
	@Column(name ="BID_SELECTED")
	private boolean bidselect;
	
	public Bid_ItemsBean() {
		// TODO Auto-generated constructor stub
	}
	
	public void setbidid(int  bidid)
	{
		this.bidid =  bidid;
	}
	
	public void setbidder(USER_IDBean user)
	{
		this.bidder = user;
	}
	
	public void setItem(Sell_ItemsBean sbean)
	{
		this.Item = sbean;
	}
	
		
	public void setbidvalue(int cid)
	{
		this.bidvalue = cid;
	}
	
	public void setbidselect(boolean cid)
	{
		this.bidselect = cid;
	}
	
	public int getbidid()
	{
		return this.bidid;
		 
	}
	
	public Sell_ItemsBean getItem()
	{
		return this.Item;
	}
	
	public int getbidvalue()
	{
		return this.bidvalue;
		 
	}
	
	public boolean getbidselect()
	{
		return this.bidselect;
	}
	
	public USER_IDBean getbidder()
	{
		return this.bidder;
	}


}


