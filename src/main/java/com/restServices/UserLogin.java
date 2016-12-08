package com.restServices;

import java.util.Date;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.Logic.User_LoginService;
import com.Logic.User_SignupService;
import com.bean.USER_IDBean;
import com.bean.USER_INFOBean;

@Path("/Login")
public class UserLogin {

	public UserLogin() {
		// TODO Auto-generated constructor stub
	}
	
	@GET	
    @Path("/{parameter}")
    //@Produces(MediaType.APPLICATION_JSON)
    public Response loginValidationTest( @PathParam("parameter") String Email,	      
      @DefaultValue("Nothing to say") @QueryParam("Password")String pwd,@QueryParam("Location")String loc, @QueryParam("key") String key)
    {
      	if(key.equals("wpl"))
      	{
		System.out.println("the email is " + Email);
    	User_SignupService Service = new User_SignupService();	   
    	USER_INFOBean user = Service.findByEmail(Email);
    	if(user == null)
    		{
    		String output = "false=false";
    		System.out.println("the status is : " + output + " as the object is null");
    		return Response.status(200).entity(output).build(); 
    		}
    	else
    	{
    	    if(!(user.getpwd().equals(pwd)))
    	     {
    	    	String output = "false=false";
    	    	System.out.println("the status is : " + output + "the given password is " + pwd + " and other is " + user.getpwd());
        		return Response.status(200).entity(output).build(); 
    	     }
    	    else
    	    {
    	    	User_SignupService us = new User_SignupService();
    	    	USER_INFOBean Bean = us.findByEmail(Email);
    	    	User_LoginService ls = new User_LoginService();    
    	    	int userid = ls.findByEmail(Bean).getUSERID();
    	    	String output = Integer.toString(userid) + "=" + Bean.getFirstName();
    	    	//setting the last login and location
    	    	loc = "Texas";
    	    	Date date = new Date();
    	    	USER_IDBean bean = ls.findByUserid(userid);
    	        bean.setlastlogin(date);
    	        bean.setlocation(loc);
    	        ls.update(bean);
    	    	System.out.println("the status is : " + output + " the bean is: " + Bean.getEmail() + " :: " + Bean.getpwd());
        		return Response.status(200).entity(output).build(); 
    	    }
    	}
    	       
    }
      	
      	else
      		return Response.status(200).entity("ERROR").build(); 
    }		

   }
