package com.rest;


import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class LoginREST {

  public String[] LoginValid(String em, String pass) {
	  String[] res = new String[2];
	try {

		Client client = Client.create();

		WebResource webResource = client
		   .resource("http://localhost:8080/ECommApp/Login/" + em + "?Password="+pass+"&key="+"wpl");		
		
		ClientResponse response = webResource.path("/").type(MediaType.TEXT_HTML).get(ClientResponse.class);
		String result = response.getEntity(String.class);

		res = result.split("=");
		System.out.println(res[0] + "-- " + res[1]);

	  } catch (Exception e) {

		e.printStackTrace();

	  }
	return res;

	}
}

