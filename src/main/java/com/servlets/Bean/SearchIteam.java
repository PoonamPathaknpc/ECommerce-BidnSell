package com.servlets.Bean;

public class SearchIteam {
	
	private String itemid;
	private String name;
	private String desc;
	private String pop;
	private String dept;
	private String gender;
    private String used;
    private String quantity;
    
    public SearchIteam(){
    	
    }

	public SearchIteam(String itemid , String name , String desc, String pop , String dept , String gender, String used) 
	{
		// TODO Auto-generated constructor stub
		this.itemid = itemid;
		this.name = name;
		this.desc = desc;
		this.pop = pop;
		this.dept = dept;
		this.gender = gender;
		this.used = used;
		 
	}
	


	//getters and setters
	
	public void setitemid(String p )
	{
		this.itemid = p;
	}
	
	public void setquantity(String p )
	{
		this.quantity = p;
	}
	
	public void setname(String p )
	{
		this.name = p;
	}
	
	public void setdesc(String qty )
	{
		this.desc= qty;
	}
	
	public void setpop(String p )
	{
		this.pop = p;
	}
	
	public void setdept(String p )
	{
		this.dept = p;
	}
	

	public void setgender(String p )
	{
		this.gender = p;
	}
	
	public void setused(String p )
	{
		this.used = p;
	}
	
	
	
	public String getitemid( )
	{
		return this.itemid;
	}
	
	public String getname( )
	{
		return this.name;
	}
	
	public String getpop()
	{
		return this.pop;
	}
	
	public String getdesc()
	{
		return this.desc;
	}
	
	public String getdept() 
	{
		return this.dept;
	}
	
	
	public String getused() 
	{
		return this.used;
	}
	

	public String getgender() 
	{
		return this.gender;
	}
	
	public String getquantity() 
	{
		return this.quantity;
	}
	
	
	
}
