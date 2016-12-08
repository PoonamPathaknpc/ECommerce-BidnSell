package com.restServices;

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

@Path("/AddCart")
public class AddtoCart {

	public AddtoCart() {
		// TODO Auto-generated constructor stub
	}
	
	
	@GET	
    @Path("/{parameter}")	
    public Response AddItem(@DefaultValue("0") @QueryParam("UserInfo") String Userid , 
  	 @QueryParam("ItemInfo") String ItemId, @QueryParam("Quantity") String Quantity,@QueryParam("Price") String Price, 
  	 @QueryParam("key") String key)
    {
		if(key.equals("wpl"))
		{
		System.out.println(Userid + " the user : " );
		System.out.println(ItemId + " the item : " );
		System.out.println(Quantity + " the qty : " );
		System.out.println(Price + " the Price: " );
		int userid = Integer.parseInt(Userid); 		
		int itemid = Integer.parseInt(ItemId);
		int qty = Integer.parseInt(Quantity);
		int price = Integer.parseInt(Price);
		String Status = null;
		Items_SellService its = new Items_SellService();
		
		//System.out.println(its.findByItemId(itemid).getClass());
		Sell_ItemsBean sitem = its.findByItemId(itemid);
		int Orig_Quantity = sitem.getQty();
		
		
		if(Orig_Quantity < qty)
			Status = "FALSE";
		else
		{
			Cart_AddDisplayService cad = new Cart_AddDisplayService();
			Cart_Bean cb = new Cart_Bean();	
			User_LoginService ul = new User_LoginService();
			USER_IDBean USER = ul.findByUserid(userid);
			cb.setuser(USER);
			cb.setItems_Sell(sitem);
			cb.setprice(price);
			cb.setQty(qty);
			cad.persist(cb);			
			Status = Integer.toString(cb.getcartid());
		}
		    	   	   	
    	
    	return Response.status(200).entity(Status).build(); 	
    	    
		}
		
		else 
			return Response.status(200).entity("ERROR").build(); 
        
    
    }

}
