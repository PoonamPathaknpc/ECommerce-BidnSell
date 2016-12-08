package com.bean;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SELL_ITEMS")
public class Sell_ItemsBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ITEM_ID")
	private int itemid;
	
	@OneToOne
	@JoinColumn(name = "SELLER_ID")
    private USER_IDBean Seller;
	
	@Column(name = "DEPARTMENT")
	private String Department;
	
	@Column(name = "POPULARITY")
	private int Popularity;
	
	@Column(name = "SCOPE_GENDER")
	private char scope_gender;
	
	@Column(name = "USED")
	private boolean used;
	
	@Column(name = "ITEMNAME")
	private String Item_name;
	
	@Column(name = "ITEM_DESC")
	private String Item_Desc;
	
	@Column(name = "IS_BIDDABLE")
	private boolean is_biddable;
	
	@Column(name = "QUANTITY")
	private int Qty;
	

	public Sell_ItemsBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	//getters and setters of the classes....
	
			public void setPopularity(int id)
			{
				this.Popularity = id;
			}
			
			
			public void setitemid(int id)
			{
				this.itemid = id;
			}
			
			public void setSeller(USER_IDBean bean)
			{
				this.Seller = bean;
			}
			
			public void setDepartment(String dept)
			{
				this.Department = dept;
			}
			
			public void setscope_gender(char sc)
			{
				
				this.scope_gender = sc;
			}
			
			public void setused(boolean set)
			{
				this.used = set;
			}
			
			public void setItem_name(String Item_name)
			{
				
				this.Item_name = Item_name;
			}
			
			public void setItem_Desc(String Item_Desc)
			{
				this.Item_Desc = Item_Desc;
				
			}
			
			
			public void setis_biddable(boolean st)
			{
				this.is_biddable = st;
				
			}
			
			public void setQty(int zp)
			{
				
				this.Qty = zp;
			}
			
						
						
			public int getitemid()
			{
				return this.itemid;
			}
			
			public USER_IDBean getSeller()
			{
				return this.Seller;
			}
			
			public String getDepartment()
			{
		      return this.Department;
				
			}
			
			public char getscope_gender()
			{
				
				return this.scope_gender;
			}
			
			public String getItem_name()
			{
				return this.Item_name;
				
			}
			
			
			public String getItem_Desc()
			{
				
				return this.Item_Desc;
			}
			
			public boolean getis_biddable()
			{
				
				return this.is_biddable;
			}
			
			
			public int getQty()
			{
				
				return  this.Qty;
			}
			
			
			public int getPopularity()
			{
				return this.Popularity;
			}
		
			public boolean getused()
			{
				return this.used;
			}
		
}


