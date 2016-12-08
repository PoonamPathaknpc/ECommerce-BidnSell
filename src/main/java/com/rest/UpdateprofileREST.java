package com.rest;



import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class UpdateprofileREST {
	
	
	public void Update(String userId,String fname,String lname,String faddr, String phone, String zip, String city, String state) {
		  String res = "";
		try {
			
			Client client = Client.create();
            System.out.println(userId + ":" + fname + ":" + lname + ":" + phone + ":" + zip + ":" + city + ":" + state + ":" + phone + ":" +  faddr);
			WebResource webResource = client
			   .resource("http://localhost:8080/ECommApp/UserProfile/Update?userId="+userId + "&fname=" + fname + "&lname=" + lname + "&fddr=" + faddr +"&zip=" + zip + "&city=" + city + "&state=" + state + "&phone=" + phone+"&key="+"wpl");
	
			ClientResponse response = webResource.path("/").type(MediaType.TEXT_HTML).get(ClientResponse.class);
			res = response.getEntity(String.class);

		  } catch (Exception e) {

			e.printStackTrace();

		  }
		

		}

}
