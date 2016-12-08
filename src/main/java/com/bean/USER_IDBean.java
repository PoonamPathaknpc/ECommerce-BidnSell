package com.bean;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USER_ID")
public class USER_IDBean {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USERID")
	private int USERID;
	
	@OneToOne
	@JoinColumn(name = "EMAIL")
	private USER_INFOBean Uinfo;
	
	@Column(name = "LASTLOGIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastlogin;
	
	
	@Column(name = "LOCATION", nullable = false, columnDefinition = "VARCHAR(50) DEFAULT 'TEXAS'" )
	private String location;
	
	public USER_IDBean() {
		// TODO Auto-generated constructor stub
	}
    
	public void setlastlogin(Date date)
    {
    	this.lastlogin = date;
    	
    }
	
    
	
	public void setUSERID(int uid)
	{
		this.USERID = uid;
	}
	
	
	public void setlocation(String loc)
	{
		this.location = loc;
	}
	
	public void setUinfo(USER_INFOBean Uinfo)
	{
		this.Uinfo = Uinfo;
	}
	
	public USER_INFOBean getUinfo()
	{
		return this.Uinfo;
	}
	
	public int getUSERID()
	{
		
		return this.USERID;
		 
	}
	
	public Date getlastlogin()
    {
		
    	return this.lastlogin;
    	
    }
	
	public String getlocation()
	{
		return this.location;
	}
	
	
	
	
}
