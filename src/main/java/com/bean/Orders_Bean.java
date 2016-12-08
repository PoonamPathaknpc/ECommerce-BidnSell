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
@Table(name = "ORDERS")
public class Orders_Bean {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID")
	private int orderid;
	
	@OneToOne
	@JoinColumn(name = "ITEM_ID")
    private Sell_ItemsBean Items_Sold;
	
	@OneToOne
	@JoinColumn(name = "USERID")
    private USER_IDBean user;
	
	@Column(name = "QUANTITY")
	private int Qty; 

	@Column(name = "PRICE")
	private int price; 
   


	public Orders_Bean() {
		// TODO Auto-generated constructor stub
	}
	
	public void setcorderid(int oid)
	{
		this.orderid = oid;
	}
	
	public void setuser(USER_IDBean user)
	{
		this.user = user;
	}
	
	public void setItems_Sold(Sell_ItemsBean sbean)
	{
		this.Items_Sold = sbean;
	}
	
	public void setQty(int cid)
	{
		this.Qty = cid;
	}
	
	public void setprice(int cid)
	{
		this.price = cid;
	}
	
	public int getcartid()
	{
		return this.orderid;
		 
	}
	
	public Sell_ItemsBean getItems_Sell()
	{
		return this.Items_Sold;
	}
	
	public int getQty()
	{
		return this.Qty;
		 
	}
	
	public int getprice()
	{
		return this.price;
		 
	}
	
	public USER_IDBean getuser()
	{
		return this.user;
	}
	


}

