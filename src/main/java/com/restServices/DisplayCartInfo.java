package com.restServices;

import java.util.Iterator;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import com.Logic.User_LoginService;
import com.Logic.Cart_AddDisplayService;
import com.bean.Cart_Bean;
import com.bean.USER_IDBean;

@Path("/displayCart")
public class DisplayCartInfo {

	public DisplayCartInfo() {
		// TODO Auto-generated constructor stub
	}
	
	@GET	
    @Path("/Cart")	
    public Response Cartinformation( @QueryParam("userId") String Userid , @QueryParam("key") String key)
    {
		if(key.equals("wpl"))
		{
		System.out.println(Userid);
		int userid = Integer.parseInt(Userid); 
   	    User_LoginService loginservice = new User_LoginService();
    	USER_IDBean user = loginservice.findByUserid(userid);
    	Cart_AddDisplayService cad = new Cart_AddDisplayService();
    	List<Cart_Bean> cartitems = cad.findByUser(user);
    	Iterator<Cart_Bean> It = cartitems.iterator();
    	String Cartinfo = "";
    	if(cartitems.size()==0)
    	{
    		System.out.println("there is no item in teh cart");
    		Cartinfo = "FALSE";
    	}
    	else
    	{
    	while(It.hasNext())
    	{
    	
    	Cart_Bean cb = (Cart_Bean)It.next();
    	Cartinfo = Cartinfo + "=ITEM_ID:" + cb.getItems_Sell().getitemid() + "=USER_ID:" + cb.getuser().getUSERID() + "=ITEM_NAME:" + cb.getItems_Sell().getItem_name() + 
    			"=Quantity:" + Integer.toString(cb.getQty()) + "=Price:" +Integer.toString(cb.getprice());
    	   	
    	}
    	System.out.println(Cartinfo);
    	}
    	return Response.status(200).entity(Cartinfo).build(); 	
		}
		
		return Response.status(200).entity("ERROR").build();
        }


}
