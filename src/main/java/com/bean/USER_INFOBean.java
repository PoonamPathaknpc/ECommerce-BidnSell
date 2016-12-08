package com.bean;

	import java.util.Date;

import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

	//entity class
	@Entity
	@Table(name = "USER_INFO")
	public class USER_INFOBean {
		@Id 
		@Column(name = "EMAIL")
		private String Email;
		@Column(name = "FIRSTNAME")
		private String FirstName; 
		@Column(name = "LASTNAME")
		private String LastName;
		@Column(name = "PHONENUM ")
		private String PHONENUM;
		@Column(name = "FADDR")
		private String FirstAddr;
		@Column(name = "CITY")
		private String City; 
		@Column(name = "STATE ")
		private String State;
		@Column(name = "ZIPCODE")
		private String Zipcode;
		@Column(name = "PWD")
		private String pwd;
		
		
		public USER_INFOBean()
		{
			
		}
		
		public USER_INFOBean(String Email, String Fname, String LNAME,String PHN, String FAddr , String City, String State, String ZP, String pwd)
		{
			this.Email = Email;
			this.FirstName = Fname;
			this.LastName = LNAME;
			this.PHONENUM = PHN;
			this.FirstAddr = FAddr;
			this.City = City;
			this.State = State;
			this.Zipcode = ZP;
			this.pwd = pwd;
			
		}
		
		//getters and setters of the classes....
		
		public void setEmail(String EM)
		{
			this.Email = EM;
		}
		
		public void setFirstName(String Fname)
		{
			this.FirstName = Fname;
		}
		
		public void setLastName(String Lname)
		{
			this.LastName = Lname;
		}
		
		public void setPHONENUM(String Phn)
		{
			
			this.PHONENUM = Phn;
			 
		}
		
		public void setFirstAddr(String Faddr)
		{
			
			this.FirstAddr = Faddr;
		}
		
		public void setCity(String City)
		{
			this.City = City;
			
		}
		
		
		public void setState(String st)
		{
			this.State = st;
			
		}
		
		public void setZipcode(String zp)
		{
			
			this.Zipcode = zp;
		}
		
		
		public void setpwd(String pwd)
		{
			this.pwd = pwd;
			
		}
		
			
		public String getEmail()
		{
			return this.Email;
		}
		
		public String getFirstName()
		{
			return this.FirstName;
		}
		
		public String getLastName()
		{
			return this.LastName;
		}
		
		public String getPHONENUM()
		{
	      return this.PHONENUM;
			
		}
		
		public String getFirstAddr()
		{
			
			return this.FirstAddr;
		}
		
		public String getCity()
		{
			return this.City;
			
		}
		
		
		public String getState()
		{
			
			return this.State;
		}
		
		public String getZipcode()
		{
			
			return this.Zipcode;
		}
		
		
		public String getpwd()
		{
			
			return  this.pwd;
		}
		
		
}
