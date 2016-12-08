package com.restServices;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import com.Logic.Cart_AddDisplayService;
import com.Logic.OrderHistory_CheckoutService;
import com.Logic.User_LoginService;
import com.bean.Cart_Bean;
import com.bean.Orders_Bean;
import com.bean.USER_IDBean;

@Path("/OrderHistory")
public class OrderHistory {

	public OrderHistory() {
		// TODO Auto-generated constructor stub
	}



@GET	
@Path("/Order")	
public Response getOrderHistory( @QueryParam("userId") String Userid , @QueryParam("key") String key)
{
	if(key.equals("wpl"))
	{
	int userid = Integer.parseInt(Userid); 
	User_LoginService loginservice = new User_LoginService();
	USER_IDBean user = loginservice.findByUserid(userid);
	OrderHistory_CheckoutService orderhis = new OrderHistory_CheckoutService();
	List<Orders_Bean> orders =  orderhis.findByUser(user);
	Iterator<Orders_Bean> It = orders.iterator();
	String orderinfo = "";
	while(It.hasNext())
	{
		
	Orders_Bean od = (Orders_Bean)It.next();
	orderinfo = orderinfo + "ITEM_ID:" + od.getItems_Sell().getitemid() + "=ITEM_NAME:" + od.getItems_Sell().getItem_name() + 
			"=Quantity:" + od.getQty() + "=Price:" +od.getprice() + ",";
	   	
	}
	System.out.println(orderinfo);
	return Response.status(200).entity(orderinfo).build(); 	
	}
	
	else
		return Response.status(200).entity("ERROR").build(); 	
		
	
    

}


}