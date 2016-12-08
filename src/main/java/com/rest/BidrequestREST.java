package com.rest;

import javax.ws.rs.core.MediaType;
import org.json.JSONObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class BidrequestREST {
	
	public void Addbid(String userId, String itemId , String price) {
		  String res = "";
		try {
			Client client = Client.create();
			System.out.println(itemId + ":: " +  userId + "::" + price);
			WebResource webResource = client
			   .resource("http://localhost:8080/ECommApp/PostBid/Bid?userId="+userId+"&price="+price+"&itemId="+itemId+"&key="+"wpl");

			ClientResponse response = webResource.path("/").type(MediaType.TEXT_HTML).get(ClientResponse.class);
			res = response.getEntity(String.class);

		  } catch (Exception e) {

			e.printStackTrace();

		  }
		

		}

}
