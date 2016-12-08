package com.restServices;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import com.Logic.BidItemsService;
import com.Logic.ImageService;
import com.Logic.Items_SellService;
import com.Logic.User_LoginService;
import com.bean.Bid_ItemsBean;
import com.bean.Image_Bean;
import com.bean.Sell_ItemsBean;
import com.bean.USER_IDBean;

/*
 * User can post items and 
 * View list of items posted for bidding... (user)
 * User chooses the bid value 
 */

@Path("/PostedItem")
public class Post_ItemstoBuy {

	public Post_ItemstoBuy() {
		// TODO Auto-generated constructor stub
	}
	
  @GET	
  @Path("/Postit")
  public Response PostSellingItem( @QueryParam("Itemname") String itemname, @DefaultValue("1") @QueryParam("userid") String userid,
		@QueryParam("Item_Desc") String item_des,@DefaultValue("1") @QueryParam("Quantity") String quantity,
  	    @DefaultValue("U") @QueryParam("scopegender") String scg,@QueryParam("Dept") String dept,
  	    @QueryParam("used") String used, @QueryParam("key") String key)
   {
	if(key.equals("wpl"))
	{
	  System.out.println(userid);
	  int Userid = Integer.parseInt(userid);
	  int Qty = Integer.parseInt(quantity);
	  
	  User_LoginService userservice = new User_LoginService();
	  USER_IDBean user  = userservice.findByUserid(Userid);
	  
	  Sell_ItemsBean itemssell = new Sell_ItemsBean();
	  itemssell.setDepartment(dept);
	  itemssell.setItem_name(itemname);
	  itemssell.setItem_Desc(item_des);
	  itemssell.setscope_gender(scg.charAt(0));
	  itemssell.setSeller(user);
	  itemssell.setQty(Qty);	  
	  itemssell.setis_biddable(true); 
	  if(used == "FALSE")
		  itemssell.setused(false);
	  else
		  itemssell.setused(true);
	  Random rand = new Random();
	  int  popularity = rand.nextInt(20) + 1;
	  itemssell.setPopularity(popularity);
	  Items_SellService itemtosell = new Items_SellService();
	  itemtosell.persist(itemssell);
	  
	 /*	  
	 // creating image table
	  Image_Bean img = new Image_Bean();
	  img.setImageURI(Imageuri);
	  img.setItem(itemssell);
	  img.setImagename(Imageuri);
	  ImageService imgservice = new ImageService();
	  imgservice.persist(img);
	 */	    	
  	   String output = Integer.toString(itemtosell.findBySeller(user).size())  ;
       return Response.status(200).entity(output).build();
	}
	else
		return Response.status(200).entity("ERROR").build();
	
  	    }
  
  
     // Select a bid for the product  
 	 @GET	
     @Path("/ChooseBid")	
     public Response ChooseBidforItem(@DefaultValue("0")@QueryParam("bidId") String Bidid, @QueryParam("key") String key)
     {
 		if(key.equals("wpl"))
 		{
 		System.out.println(Bidid + " the bidid : " );		
 		int bidid = Integer.parseInt(Bidid);
 		BidItemsService bidding = new BidItemsService();
 		Bid_ItemsBean bidrecord = bidding.findByBidID(bidid);
 		bidrecord.setbidselect(true);
 		String bidder = bidrecord.getbidder().getUinfo().getEmail();
 		String user = bidrecord.getItem().getSeller().getUinfo().getEmail();
 		bidding.persist(bidrecord);	
 		
 		//delete the other bids..
 		bidding.delBidSameItem(bidrecord.getItem(), bidrecord.getbidder());
 		
 		//delete the item for which the bidding is approved.
 		Sell_ItemsBean biddeditem = bidrecord.getItem();
 		Items_SellService sellservice = new Items_SellService();
 		sellservice.delete(biddeditem);
 		
 		/*
 		// After user chooses the bid the cart of user is added with the item ..from that bidder ..
 		String ItemId = Integer.toString(bidrecord.getItem().getitemid());
 		String bidvalue = Integer.toString(bidrecord.getbidvalue());
 		String qty = Integer.toString(bidrecord.getItem().getQty());
     	AddtoCart cartaddition = new AddtoCart();    	
     	cartaddition.AddItem(Userid, ItemId, qty,bidvalue);
     	*/
 		String status = "usermail:" + user + "=biddermail:" + bidder;
     	return Response.status(200).entity(status).build(); 
 		}
 		else
 			return Response.status(200).entity("ERROR").build(); 	
    
     }
 	 
 	 // view items posted for bidding 
 	@GET	
    @Path("/ItemsPosted")	
    public Response ItemsPosted(@DefaultValue("0")@QueryParam("userid") String Userid, @QueryParam("key") String key)
    {
		if(key.equals("wpl"))
		{
    	int userid = Integer.parseInt(Userid);
 		System.out.println("userid is " + Userid);
   	    User_LoginService loginservice = new User_LoginService();
    	USER_IDBean user = loginservice.findByUserid(userid);
    	System.out.println(user.getUSERID() + "::: " + user.getlastlogin());
    	Items_SellService itemsint = new Items_SellService();
    	List<Sell_ItemsBean>items = itemsint.findBySeller(user);
    	Iterator<Sell_ItemsBean> It = items.iterator();
    	String Iteminfo = "";
    	while(It.hasNext())
    	{
    		
    	Sell_ItemsBean cb = (Sell_ItemsBean)It.next();
    	Iteminfo = Iteminfo + "itemId:" + cb.getitemid() + "=name:" + cb.getItem_name()+ "=desc:" + cb.getItem_Desc() + 
    			"=quantity:" + cb.getQty() +  ";";
    	   	
    	}
    	System.out.println(Iteminfo);
    	return Response.status(200).entity(Iteminfo).build(); 
		}
		else
			return Response.status(200).entity("ERROR").build(); 
 		
    }
         
   }


