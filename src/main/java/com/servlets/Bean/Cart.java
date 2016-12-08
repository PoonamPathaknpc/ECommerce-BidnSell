package com.servlets.Bean;

public class Cart {
	
	private String userId;
	private String itemId;
	private String Item_Name;
	private String quantity;
	private String price;	

	public Cart() {
		// TODO Auto-generated constructor stub
		
			
	}
	
	public Cart(String user , String itemid , String Itname ,String Qty , String Price)
	{
		this.userId = user;
		this.itemId = itemid;
		this.Item_Name = Item_Name;
		this.quantity = quantity;
		this.price = Price;
		
			
	}

	//getters and setters
	
	public void setuserId(String p )
	{
		this.userId = p;
	}
	
	public void setprice(String p )
	{
		this.price = p;
	}
	
	public void setquantity(String qty )
	{
		this.quantity= qty;
	}
	
	public void setitemId(String p )
	{
		this.itemId = p;
	}
	
	public void setItem_Name(String p )
	{
		this.Item_Name = p;
	}
	
	public String getuserId( )
	{
		return this.userId;
	}
	
	public String getprice( )
	{
		return this.price;
	}
	
	public String getquantity()
	{
		return this.quantity;
	}
	
	public String getitemId()
	{
		return this.itemId;
	}
	
	public String getItem_Name( )
	{
		return this.Item_Name;
	}
	
	
	
}
