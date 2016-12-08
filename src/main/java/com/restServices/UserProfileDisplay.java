package com.restServices;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.Logic.Cart_AddDisplayService;
import com.Logic.User_LoginService;
import com.Logic.User_SignupService;
import com.bean.Cart_Bean;
import com.bean.USER_IDBean;
import com.bean.USER_INFOBean;

@Path("/UserProfile")
public class UserProfileDisplay {

	public UserProfileDisplay() {
		// TODO Auto-generated constructor stub
		
   }
	
	@GET	
    @Path("/display")	
    public Response DisplayProfileDetail( @QueryParam("userId") String Userid, @QueryParam("key") String key)
    {
      	if(key.equals("wpl"))
      	{
    User_LoginService loginservice = new User_LoginService();	
	String uinfostring = "";
	System.out.println(Userid + ": is the userid");
	int userid = Integer.parseInt(Userid); 
	
	USER_IDBean user = loginservice.findByUserid(userid);	
	USER_INFOBean userinfo = user.getUinfo();
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	Date date = user.getlastlogin();
	String reportDate = df.format(date);
		
	uinfostring = "fname:" + userinfo.getFirstName() + "=lname:" + userinfo.getLastName() +  
			"=email:" + userinfo.getEmail() + "=faddr:" +userinfo.getFirstAddr() + "=city:" + userinfo.getCity() + "=state:" + userinfo.getState() + "=zip:" + userinfo.getZipcode() + "=Phone:" + userinfo.getPHONENUM() + "=location:" + user.getlocation()  + "=datetime:" + reportDate;
	System.out.println(uinfostring);
	
	return Response.status(200).entity(uinfostring).build(); 	
	    
    }
   
	else
		return Response.status(200).entity("ERROR").build();
    }
		
	
	
	@GET	
    @Path("/Update")	
    public Response UpdateProfile( @QueryParam("userId") String userId,@QueryParam("fname") String fname, @QueryParam("lname") String lname,@QueryParam("fddr") String faddr,@QueryParam("zip") String zip,@QueryParam("city") String city,@QueryParam("state") String state,@QueryParam("phone") String phone, @QueryParam("key") String key)
    {
      	if(key.equals("wpl"))
      	{
    User_LoginService loginservice = new User_LoginService();	
	System.out.println(userId + ": is the userid");
	int userid = Integer.parseInt(userId); 
	String info = "";
	USER_IDBean user = loginservice.findByUserid(userid);	
	USER_INFOBean userinfo = user.getUinfo();
	userinfo.setFirstAddr(faddr);
	userinfo.setCity(city);
	userinfo.setState(state);
	userinfo.setZipcode(zip);    
	userinfo.setFirstName(fname);
	userinfo.setLastName(lname);
	userinfo.setPHONENUM(phone);
	System.out.println(userId + ":" + fname + ":" + lname + ":" + phone + ":" + zip + ":" + city + ":" + state + ":" + phone +  ":" + faddr);
	User_SignupService service = new User_SignupService();
	System.out.println("updating the changes...");
	service.update(userinfo);
    System.out.println(info);
	
	return Response.status(200).entity(info).build(); 
      	}
      	else
      		return Response.status(200).entity("ERROR").build(); 	
	    
    }
	
}
    	
     