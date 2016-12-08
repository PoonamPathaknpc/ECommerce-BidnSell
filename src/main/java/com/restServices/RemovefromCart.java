package com.restServices;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import com.Logic.Cart_AddDisplayService;
import com.Logic.Items_SellService;
import com.Logic.User_LoginService;
import com.bean.Cart_Bean;
import com.bean.Sell_ItemsBean;
import com.bean.USER_IDBean;

@Path("/RemoveCart")
public class RemovefromCart {

	public RemovefromCart() {
		// TODO Auto-generated constructor stub
	}
	@GET	
    @Path("/{parameter}")	
    public Response RemoveItem( @PathParam("parameter") String Userid , 
  	      @QueryParam("itemId") String ItemId, @QueryParam("key") String key)
    {
		System.out.println(key + "server...");
		System.out.println(Userid + " the user : " );
		System.out.println(ItemId + " the item : " );
		
    	if(key.equals("wpl"))
    	{
		
		
		int userid = Integer.parseInt(Userid); 		
		int itemid = Integer.parseInt(ItemId);
		Items_SellService its = new Items_SellService();		
		Sell_ItemsBean sitem = its.findByItemId(itemid);
		Cart_AddDisplayService cad = new Cart_AddDisplayService();
		cad.delete(sitem);	
				
	    User_LoginService loginservice = new User_LoginService();
    	USER_IDBean user = loginservice.findByUserid(userid);    	
    	List<Cart_Bean> cartitems = cad.findByUser(user);
    	Iterator<Cart_Bean> It = cartitems.iterator();
    	String Cartinfo = "";
    	while(It.hasNext())
    	{
    	
    	Cart_Bean cb = (Cart_Bean)It.next();
    	Cartinfo = Cartinfo + "=ITEM_ID:" + cb.getItems_Sell().getitemid() +  "=USER_ID:" + cb.getuser().getUSERID() + "=ITEM_NAME:" + cb.getItems_Sell().getItem_name() + 
    			"=Quantity:" + Integer.toString(cb.getQty()) + "=Price:" +Integer.toString(cb.getprice());
    	   	
    	}
    	System.out.println(Cartinfo);
    	return Response.status(200).entity(Cartinfo).build();
        
        }
    	
    	else
    		return Response.status(200).entity("ERROR").build();	
    		
    }
}
