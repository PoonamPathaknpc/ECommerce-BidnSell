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
@Table(name = "CART")
public class Cart_Bean {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CART_ID")
	private int cartid;
	
	@OneToOne
	@JoinColumn(name = "ITEM_ID")
    private Sell_ItemsBean Items_Sell;
	
	@OneToOne
	@JoinColumn(name = "USERID")
    private USER_IDBean user;
	
	@Column(name = "QUANTITY")
	private int Qty; 

	@Column(name = "PRICE")
	private int price; 
   

	public Cart_Bean() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void setcartid(int cid)
	{
		this.cartid = cid;
	}
	
	public void setuser(USER_IDBean user)
	{
		this.user = user;
	}
	
	public void setItems_Sell(Sell_ItemsBean sbean)
	{
		this.Items_Sell = sbean;
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
		return this.cartid;
		 
	}
	
	public Sell_ItemsBean getItems_Sell()
	{
		return this.Items_Sell;
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
