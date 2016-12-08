package com.rest;


import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ViewbidREST {
	
	
	public String getItems(String userId) {
		  String res = null;
		try {
			JSONObject js=new JSONObject();
			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://localhost:8080/ECommApp/PostedItem/ItemsPosted?userid="+userId+"&key="+"wpl");
			
			ClientResponse response = webResource.path("/").type(MediaType.TEXT_HTML).get(ClientResponse.class);
			res = response.getEntity(String.class);
			System.out.println(res +" is the state"); 

		  } catch (Exception e) {

			e.printStackTrace();

		  }
		return res;

		}

}
