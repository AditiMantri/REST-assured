package com.pyxispm.MediaPlanManagement;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MediaPlanManagement {
	@Test
	public void getMediaPlans()
	{
	 RestAssured.baseURI = "https://dev-aiquire-dashboard.web.app/dashboard/api/clients/media-plans";
	 RequestSpecification httpRequest = RestAssured.given();
	 Response response = httpRequest.get("/");
	 int statusCode = response.getStatusCode();
	 Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
	}
}
