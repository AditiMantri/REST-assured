package com.pyxispm.MediaPlanManagement;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getMediaPlans {
	@Test
	public void getMediaPlans() {
		
		  RestAssured.baseURI = "https://dev-aiquire-dashboard.web.app/dashboard/api";
		  RequestSpecification httpRequest = RestAssured.given(); 
		  Response response =  httpRequest.get("/clients/media-plans"); 
		  int statusCode =  response.getStatusCode(); 
		  Assert.assertEquals(statusCode , 200 , "Correct status code returned");
		  System.out.println(response.getBody().asString());
		 
	}
}
