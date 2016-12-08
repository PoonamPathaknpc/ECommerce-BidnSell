package com.rest;

import java.net.URLEncoder;

import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PostitemREST {
	
	
	public void Postitem(String userId , String name , String desc, String quantity , String scopegender , String dept , String used) {
		  String res = null;
		try {
			JSONObject js=new JSONObject();
			Client client = Client.create();
			System.out.println(userId + "is the id");

			WebResource webResource = client
					   .resource("http://localhost:8080/ECommApp/PostedItem/Postit?Itemname="+URLEncoder.encode(name, "UTF-8")+"&userid="+userId+"&Item_Desc="+URLEncoder.encode(desc, "UTF-8")+"&Quantity="+quantity+"&scopegender="+scopegender+"&Dept="+dept+"&used="+used+"&key="+"wpl");



			ClientResponse response = webResource.path("/").type(MediaType.TEXT_HTML).get(ClientResponse.class);
			res = response.getEntity(String.class);

		  } catch (Exception e) {

			e.printStackTrace();

		  }
	

		}

}
