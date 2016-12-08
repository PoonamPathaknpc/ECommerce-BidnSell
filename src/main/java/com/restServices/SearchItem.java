package com.restServices;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.Logic.Items_SellService;
import com.Logic.User_LoginService;
import com.Logic.User_SignupService;
import com.bean.Cart_Bean;
import com.bean.Sell_ItemsBean;
import com.bean.USER_INFOBean;

@Path("/Search")
public class SearchItem {

	public SearchItem() {
		// TODO Auto-generated constructor stub
	}
	
  @GET	
  @Path("/{parameter}")
  public Response SearchItemstoBuy( @PathParam("parameter") String SearchString, @QueryParam("key") String key, @QueryParam("userid") String userid)
  {
  	if(key.equals("wpl"))
  	{
	    String used1 = "";
    	Items_SellService Service = new Items_SellService();
    	String Iteminfo = "";
    	List<Sell_ItemsBean>  searcheditems =  Service.searchItems(SearchString); 
    
    	
    	if(searcheditems.size()==0)
    	{
    		Iteminfo = "FALSE";
    	}
    	Iterator<Sell_ItemsBean> It = searcheditems.iterator();
    	
    	while(It.hasNext())
    	{
    	
    
        Sell_ItemsBean item = (Sell_ItemsBean)It.next();
        if(item.getused()==true)
         {used1 = "Used";}
        	
        else
        	{used1 = "New";}
        if(item.getis_biddable()==true)
        {
        	System.out.println(item.getSeller().getUSERID() + "is the user id posting the item");
        	System.out.println(userid + " : is the user querying");
          if(item.getSeller().getUSERID()!= Integer.parseInt(userid))
          {
        	
       Iteminfo = Iteminfo + "=itemId:" + item.getitemid() + "=desc:" + item.getItem_Desc() + "=name:" + item.getItem_name() + 
    			"=dept:" + item.getDepartment() + "=pop:" +Integer.toString(item.getPopularity()) 
    			+ "=gender:" + Character.toString(item.getscope_gender()) + "=used:" + used1;
          }
        }
    	   	
    	}
    	System.out.println(Iteminfo);
    	return Response.status(200).entity(Iteminfo).build(); 	
  	}
  	else
  		return Response.status(200).entity("ERROR").build(); 	
         
    }
   
}
