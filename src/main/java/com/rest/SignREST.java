package com.rest;

import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class SignREST {

  public String[] Signupmethod(String em, String pass,String fn , String ln, String phn, String faddr, String city, String State,String Zp) 
  {
	  String[] res = new String[2];
	try {
		JSONObject js= new JSONObject();
		Client client = Client.create();
        System.out.println("the state is " + State);
		WebResource webResource = client
		   .resource("http://localhost:8080/ECommApp/Signup/" + em + "?FirstName=" + fn + "&LastName=" + ln +
				   "&PhoneNum=" + phn + "&FirstAddr=" + faddr + "&City=" + city + "&state=" + State + "&Zipcode=" + Zp + "&Password=" + pass+"&key="+"wpl");
       
		
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

