package com.restServices;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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



@Path("/Signup")
public class UserSignUp {

	public UserSignUp() {
		// TODO Auto-generated constructor stub
	}
	
	    @GET	
	    @Path("/{parameter}")
	    //@Produces(MediaType.APPLICATION_JSON)
	    public Response loginValidationTest( @PathParam("parameter") String Email,	      
	      @DefaultValue("User") @QueryParam("FirstName") String Fname , 
	      @QueryParam("LastName") String LNAME,@QueryParam("PhoneNum") String PHN,@QueryParam("FirstAddr") String FAddr,
	      @QueryParam("City") String City, @QueryParam("state") String State, @QueryParam("Zipcode") String ZP,
	      @DefaultValue("Nothing to say") @QueryParam("Password")String pwd,@QueryParam("location")String loc, @QueryParam("key") String key)
	    {
	      	if(key.equals("wpl"))
	      	{
	    	
	    	User_SignupService Service = new User_SignupService();	    
	    	User_LoginService ls = new User_LoginService();
	    	if(Email==null)
	    	{
	    		String output = "false=false";
	    		return Response.status(200).entity(output).build(); 
	    	}
	    	else
	    	{
	    		System.out.println("the state is in server : " + State);
	    	USER_INFOBean user = new USER_INFOBean(Email, Fname, LNAME, PHN, FAddr, City, State, ZP, pwd); 	
	    	//*** Persist - start ***	    	
	    	Service.persist(user);  
	    	USER_IDBean userid = new USER_IDBean();
	    	userid.setUinfo(user);
	    	//setting the last login
	    	//DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	    	Date date = new Date();	    	
	        userid.setlastlogin(date);
	        loc = "Texas";
	        userid.setlocation(loc);
	    	ls.persist(userid);
	    	String output = Integer.toString(ls.findByEmail(user).getUSERID()) + "=" + user.getFirstName();
	    	System.out.println(output);
	    	return Response.status(200).entity(output).build(); 
	    	}
	      	}
	    	else
	    		return Response.status(200).entity("ERROR").build(); 	
	     
	  }


}
