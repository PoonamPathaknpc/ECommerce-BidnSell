package com.rest;

import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ProfileREST {

	public String Fetch(String userId) {
		  String res = null;
		try {
			JSONObject js=new JSONObject();
			Client client = Client.create();
            System.out.println(userId + ": before even getting the profile");
			WebResource webResource = client
			   .resource("http://localhost:8080/ECommApp/UserProfile/display?userId=" +userId+"&key="+"wpl");
        
			ClientResponse response = webResource.path("/").type(MediaType.TEXT_HTML).get(ClientResponse.class);
			res = response.getEntity(String.class);

		  } catch (Exception e) {

			e.printStackTrace();

		  }
		return res;

		}
}
