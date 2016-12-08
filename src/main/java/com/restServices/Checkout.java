package com.restServices;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.Logic.Cart_AddDisplayService;
import com.Logic.Items_SellService;
import com.Logic.OrderHistory_CheckoutService;
import com.Logic.User_LoginService;
import com.bean.Cart_Bean;
import com.bean.Orders_Bean;
import com.bean.USER_IDBean;

@Path("/Checkout")
public class Checkout {

	public Checkout() {
		// TODO Auto-generated constructor stub
	}
	

	@GET	
    @Path("/co")	
    public Response CheckoutItems(@DefaultValue("0") @QueryParam("userId") String Userid , @QueryParam("key") String key)
    {
		if(key.equals("wpl"))
		{
		
		System.out.println(Userid + " the user : " );
		int userid = Integer.parseInt(Userid); 		
		String status = "";
		User_LoginService ls = new User_LoginService();
		Cart_AddDisplayService carts = new Cart_AddDisplayService();
		OrderHistory_CheckoutService Orders = new OrderHistory_CheckoutService();
		USER_IDBean user = ls.findByUserid(userid);
		List<Cart_Bean>	 cartitems = carts.findByUser(user);
		
		Iterator<Cart_Bean> It = cartitems.iterator();
    	
    	
    	while(It.hasNext())
    	{    		
    	Cart_Bean cb = (Cart_Bean)It.next();
    	Orders_Bean order = new Orders_Bean();
    	order.setItems_Sold(cb.getItems_Sell());
    	order.setprice(cb.getprice());
    	order.setQty(cb.getQty());
    	order.setuser(user);
    	Orders.persist(order); 	
    	System.out.println(Orders.findByItem_sold(cb.getItems_Sell()).getcartid());
    	}
    	
    	
    	// delete the cart items
    	carts.deleteitems(cartitems);
    	
    	status = "usermail:" + user.getUinfo().getEmail() ;
     	 
    	return Response.status(200).entity(status).build(); 	
    	    
		}
		
		else
			return Response.status(200).entity("ERROR").build(); 	
			
        
    
    }


}
