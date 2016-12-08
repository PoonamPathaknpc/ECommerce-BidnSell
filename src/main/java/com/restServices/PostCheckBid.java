package com.restServices;

import java.util.Iterator;
import java.util.List;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import com.Logic.BidItemsService;
import com.Logic.Items_SellService;
import com.Logic.User_LoginService;
import com.bean.Bid_ItemsBean;
import com.bean.Sell_ItemsBean;
import com.bean.USER_IDBean;

/* Users can bid for the items seen in search items, view the items available for bidding - Bidder
 * Users can see bids for an item they posted
 */

@Path("/PostBid")
public class PostCheckBid {

	public PostCheckBid() {
		// TODO Auto-generated constructor stub
	}

	@GET	
    @Path("/Bid")	
    public Response PostBidforItem(@DefaultValue("0") @QueryParam("userId") String Userid , 
  	      @QueryParam("itemId") String ItemId,@QueryParam("price") String Bid, @QueryParam("key") String key)
    {
    	if(key.equals("wpl"))
    	{
		System.out.println(Userid + " the bidder : " );
		System.out.println(ItemId + " the item : " );
		System.out.println(Bid + " the bid: " );
		int userid = Integer.parseInt(Userid); 		
		int itemid = Integer.parseInt(ItemId);
		int bid = Integer.parseInt(Bid);
		String Status = null;
		
		Items_SellService its = new Items_SellService();		
		Sell_ItemsBean sitem = its.findByItemId(itemid);
				
		User_LoginService ls = new User_LoginService();
		USER_IDBean bidder = ls.findByUserid(userid);
		
		BidItemsService bidding = new BidItemsService();
		Bid_ItemsBean bidrecord = new Bid_ItemsBean();
		bidrecord.setbidselect(false);
		bidrecord.setbidvalue(bid);
		bidrecord.setbidder(bidder);
		bidrecord.setItem(sitem);
		bidding.persist(bidrecord);	
		
		Status = Integer.toString(bidding.findByBidderItem(bidder, sitem).getbidid());
	
    	return Response.status(200).entity(Status).build(); 	
    	    
    	}
    	
    	else
    	{
    		return Response.status(200).entity("ERROR").build(); 	
    	}
	
    }


	@GET	
    @Path("/ViewBids")	
    public Response ViewBidsforItem(@DefaultValue("0")@QueryParam("itemId") String ItemId,@DefaultValue("0")@QueryParam("userId") String UserId,  @QueryParam("key") String key)
    {
    	if(key.equals("wpl"))
    	{
		int itemid = Integer.parseInt(ItemId); 
		Items_SellService itemsservice = new Items_SellService();
		Sell_ItemsBean item = itemsservice.findByItemId(itemid);
   	    BidItemsService bidding = new BidItemsService();
    	List<Bid_ItemsBean> bids = bidding.findByItem_sold(item);
    	Iterator<Bid_ItemsBean> It = bids.iterator();
    	String Bidinfo = "";
    	if(bids.size()==0)
    	{
    		Bidinfo = "FALSE";
    	}
    	else
    	{
    	while(It.hasNext())
    	{
    		
    	Bid_ItemsBean bid = (Bid_ItemsBean)It.next();
    	String biddername = bid.getbidder().getUinfo().getFirstName() + " " + bid.getbidder().getlastlogin();
    	Bidinfo = Bidinfo + "Bidid:" + bid.getbidid() + "=Bidder_NAME:" + biddername + 
    			"=Bid:" + bid.getbidvalue() + ";";
    	   	
    	}
    	}
    	System.out.println(Bidinfo);
    	return Response.status(200).entity(Bidinfo).build(); 	
    	}
    	
    	else
    		return Response.status(200).entity("ERROR").build(); 
        
    
    }
	

}
